package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IPeriod
import java.time.LocalDate
import java.util.*
import kotlin.math.min
import kotlin.math.max


object OperationsPeriod {
    public val TERM_BEG_FINISHED: Int = 32

    public val TERM_END_FINISHED: Int = 0

    public val WEEKSUN_SUNDAY: Int = 0

    public val WEEKMON_SUNDAY: Int = 7

    public val TIME_MULTIPLY_SIXTY: Int = 60

    public val WEEKDAYS_COUNT: Int = 7

    fun emptyMonthSchedule(): IntArray {
        return intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    }

    fun totalWeeksHours(template: IntArray): Int {
        val result = template.take(7).fold(0) { agr, x -> agr + x }

        return result
    }
    fun totalMonthHours(template: IntArray): Int {
        val result = template.take(31).fold(0) { agr, x -> agr + x }

        return result
    }
    fun daysInMonth(period: IPeriod): Int {
        val date = LocalDate.of(period.year, period.month, 1)
        return date.lengthOfMonth()
    }
    fun dateOfMonth(period: IPeriod, dayOrdinal: Int): LocalDate
    {
        val periodDay: Int = min(max(1, dayOrdinal), daysInMonth(period))

        return LocalDate.of(period.year, period.month, periodDay)
    }
    fun dayOfWeekMonToSun(periodDateCwd: Int): Int {
        // DayOfWeek Sunday = 0,
        // Monday = 1, Tuesday = 2, Wednesday = 3, Thursday = 4, Friday = 5, Saturday = 6,
        if (periodDateCwd == WEEKSUN_SUNDAY)
        {
            return WEEKMON_SUNDAY
        }
        return periodDateCwd
    }
    fun dayOfWeekFromOrdinal(dayOrdinal: Int, periodBeginCwd: Int): Int {
        // dayOrdinal 1..31
        // periodBeginCwd 1..7
        // dayOfWeek 1..7

        val dayOfWeek = (((dayOrdinal - 1) + (periodBeginCwd - 1)) % 7) + 1

        return dayOfWeek
    }

    fun weekDayOfMonth(period: IPeriod, dayOrdinal: Int): Int {
        val periodDate = dateOfMonth(period, dayOrdinal)

        val periodDateCwd = periodDate.dayOfWeek.value

        return dayOfWeekMonToSun(periodDateCwd)
    }
    fun dateFromInPeriod(period: IPeriod, dateFrom: LocalDate?): Int {
        var dayTermFrom = TERM_BEG_FINISHED

        val periodDateBeg = LocalDate.of(period.year, period.month, 1)

        if (dateFrom != null)
        {
            dayTermFrom = dateFrom.dayOfMonth
        }

        if (dateFrom == null || dateFrom < periodDateBeg)
        {
            dayTermFrom = 1
        }
        return dayTermFrom
    }

    fun dateStopInPeriod(period: IPeriod, dateEnds: LocalDate?): Int {
        var dayTermEnd = TERM_END_FINISHED

        val daysPeriod = daysInMonth(period)

        val periodDateEnd = LocalDate.of(period.year, period.month, daysPeriod)

        if (dateEnds != null)
        {
            dayTermEnd = dateEnds.dayOfMonth
        }

        if (dateEnds == null || dateEnds > periodDateEnd)
        {
            dayTermEnd = daysPeriod
        }
        return dayTermEnd
    }
    fun timesheetWeekSchedule(_period: IPeriod, secondsWeekly: Int, workdaysWeekly: Int): IntArray {
        val secondsDaily = (secondsWeekly / min(workdaysWeekly, WEEKDAYS_COUNT))

        val secRemainder = secondsWeekly - (secondsDaily * workdaysWeekly)

        val weekSchedule = (1..7).map {x -> weekDaySeconds(x, workdaysWeekly, secondsDaily, secRemainder)}.toIntArray()

        return weekSchedule
    }
    fun weekDaySeconds(dayOrdinal: Int, daysOfWork: Int, secondsDaily: Int, secRemainder: Int): Int {
        if (dayOrdinal < daysOfWork)
        {
            return secondsDaily
        }
        else if (dayOrdinal == daysOfWork)
        {
            return secondsDaily + secRemainder
        }
        return (0)
    }
    fun timesheetFullSchedule(period: IPeriod, weekSchedule: IntArray): IntArray {
        val periodDaysCount = daysInMonth(period)

        val periodBeginCwd = weekDayOfMonth(period, 1)

        val monthSchedule = (1..periodDaysCount).map { x -> secondsFromWeekSchedule(weekSchedule, x, periodBeginCwd) }.toIntArray()

        return monthSchedule
    }
    fun timesheetWorkSchedule(monthSchedule: IntArray, dayTermFrom: Int, dayTermStop: Int): IntArray {
        val timeSheet = monthSchedule.mapIndexed { i, x -> hoursFromCalendar(dayTermFrom, dayTermStop, i, x) }.toIntArray()

        return timeSheet
    }
    fun timesheetWorkContract(monthContract: IntArray, monthPosition: IntArray, dayTermFrom: Int, dayTermStop: Int): IntArray {
        val idxFrom = (dayTermFrom - 1)
        val idxStop = (dayTermStop - 1)
        var zipedMonth = monthContract.zip(monthPosition)
        val result = zipedMonth.mapIndexed<Pair<Int, Int>, Int> { idx, z ->
            var res: Int = 0
            if (idx in idxFrom..idxStop) {
                res = (z.first + z.second)
            }
            res
        }.toIntArray()
        return result
    }
    fun secondsFromPeriodWeekSchedule(period: IPeriod, weekSchedule: IntArray, dayOrdinal: Int): Int {
        val periodBeginCwd = weekDayOfMonth(period, 1)

        return secondsFromWeekSchedule(weekSchedule, dayOrdinal, periodBeginCwd)
    }
    fun secondsFromWeekSchedule(weekSchedule: IntArray, dayOrdinal: Int, periodBeginCwd: Int): Int {
        val dayOfWeek = dayOfWeekFromOrdinal(dayOrdinal, periodBeginCwd)

        val indexWeek = (dayOfWeek - 1)

        if (indexWeek < 0 || indexWeek >= weekSchedule.count())
        {
            return 0
        }
        return weekSchedule[indexWeek]
    }

    fun secondsFromScheduleSeq(timeTable: IntArray, dayOrdinal: Int, dayFromOrd: Int, dayEndsOrd: Int): Int {
        if (dayOrdinal < dayFromOrd || dayOrdinal > dayEndsOrd)
        {
            return 0
        }

        val indexTable = (dayOrdinal - dayFromOrd)

        if (indexTable < 0 || indexTable >= timeTable.count())
        {
            return 0
        }

        return timeTable[indexTable]
    }
    fun scheduleBaseSubtract(template: IntArray, subtract: IntArray, dayFrom: Int, dayStop: Int): IntArray {
        val idxFrom = (dayFrom - 1)
        val idxStop = (dayStop - 1)
        var zipedWorkAbsc = template.zip(subtract)
        val result = zipedWorkAbsc.mapIndexed {idx, z ->
            var res = 0
            if (idx in idxFrom..idxStop) {
                res = max(0, z.first - z.second)
            }
            res
        }.toIntArray()
        return result
    }
    fun plusHoursFromCalendar(dayTermFrom: Int, dayTermStop: Int, dayIndex: Int, partSeconds: Int, workSeconds: Int): Int {
        val dayOrdinal = (dayIndex + 1)

        var plusSeconds = workSeconds

        if (dayTermFrom > dayOrdinal)
        {
            plusSeconds = 0
        }
        if (dayTermStop < dayOrdinal)
        {
            plusSeconds = 0
        }
        return plusSeconds + partSeconds
    }
    fun hoursFromCalendar(dayTermFrom: Int, dayTermStop: Int, dayIndex: Int, workSeconds: Int): Int {
        val dayOrdinal = (dayIndex + 1)

        var workingDay = workSeconds

        if (dayTermFrom > dayOrdinal)
        {
            workingDay = 0
        }
        if (dayTermStop < dayOrdinal)
        {
            workingDay = 0
        }
        return workingDay
    }
}