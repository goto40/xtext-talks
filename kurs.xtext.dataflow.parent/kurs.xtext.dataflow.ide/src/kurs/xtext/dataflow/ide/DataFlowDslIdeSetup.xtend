/*
 * generated by Xtext 2.12.0
 */
package kurs.xtext.dataflow.ide

import com.google.inject.Guice
import kurs.xtext.dataflow.DataFlowDslRuntimeModule
import kurs.xtext.dataflow.DataFlowDslStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class DataFlowDslIdeSetup extends DataFlowDslStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new DataFlowDslRuntimeModule, new DataFlowDslIdeModule))
	}
	
}
