package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.providers.IPropsProvider
import org.reflections.Reflections
import java.lang.reflect.Modifier


typealias VERSION = Int

abstract class ProviderFactory<B : IPropsProvider<P>, P : IProps> : IProviderFactory<P> {
    protected abstract val defaultProvider: B

    protected abstract val emptyPeriodProps: P

    protected abstract val versions: Map<VERSION, B>

    override fun getProps(period: IPeriod): P {
        val provider: B = getProvider(period, defaultProvider) ?: return emptyPeriodProps
        return provider.getProps(period)
    }
    private fun getProvider(period: IPeriod, defProvider: B): B? {
        val maybeProvider: B? = versions.getOrDefault(period.year, null)
        if (maybeProvider == null) {
            if (period.year > defProvider.version.value) {
                return defProvider
            }
            return maybeProvider
        }
        val provider: B = maybeProvider
        if (period.year != provider.version.value) {
            return null
        }
        return provider
    }

    companion object {
        inline fun <reified B : IPropsProvider<P>, P> buildVersions(): Map<VERSION, B> {
            val providerType: Class<out B> = B::class.java

            val reflections = Reflections("org.hravemzdy.legalios.providers")

            val definedTypes = reflections.getSubTypesOf(providerType)

            return definedTypes
                .filter { x -> isValidType(x) && hasValidConstructor(x) }
                .mapNotNull { x -> x.getDeclaredConstructor().newInstance() }.associateBy { it.version.value }
        }

        inline fun <reified B : IPropsProvider<P>, P> isValidType(testType: Class<out B>): Boolean
        {
            val providerType: Class<out B> = B::class.java

            return (providerType.isAssignableFrom(testType) &&
                    !testType.isInterface && !Modifier.isAbstract(testType.modifiers))
        }

        inline fun <reified B : IPropsProvider<P>, P> hasValidConstructor(testType: Class<out B>): Boolean
        {
            val parameterlessConstructor = testType.constructors
                .singleOrNull { constructor ->  constructor.parameterCount == 0}
            return parameterlessConstructor != null
        }
    }
}