package kurs.xtext.dataflow.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

import kurs.xtext.dataflow.services.DataFlowDslGrammarAccess;

public class MyFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig config) {

		DataFlowDslGrammarAccess ga = (DataFlowDslGrammarAccess) getGrammarAccess();
		
		for (Pair<Keyword, Keyword> pair : ga.findKeywordPairs("{", "}")) {
			config.setLinewrap().after(pair.getFirst());
			config.setIndentationIncrement().after(pair.getFirst());
			config.setLinewrap().before(pair.getSecond());
			config.setIndentationDecrement().before(pair.getSecond());
			config.setLinewrap().after(pair.getSecond());
		}		
		config.setLinewrap(1, 1, 1).after(ga.getKInstanceRule());		
	}

}