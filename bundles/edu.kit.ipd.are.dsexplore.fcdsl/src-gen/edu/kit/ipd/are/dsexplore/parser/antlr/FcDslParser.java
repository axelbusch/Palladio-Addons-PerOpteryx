/*
 * generated by Xtext 2.14.0
 */
package edu.kit.ipd.are.dsexplore.parser.antlr;

import com.google.inject.Inject;
import edu.kit.ipd.are.dsexplore.parser.antlr.internal.InternalFcDslParser;
import edu.kit.ipd.are.dsexplore.services.FcDslGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class FcDslParser extends AbstractAntlrParser {

	@Inject
	private FcDslGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalFcDslParser createParser(XtextTokenStream stream) {
		return new InternalFcDslParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "BehaviourInclusion";
	}

	public FcDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FcDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
