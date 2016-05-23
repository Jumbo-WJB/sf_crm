package com.shufensoft.crm.biz.service.cvm.function;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.*;

/**
 *  JEVAL自定义函数，完成类似IfThenElse的功能
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-18 20:05  
 */
public class IfThenElseFunction implements Function {

    public String getName() {
        return "ifThenElse";
    }

    public FunctionResult execute(Evaluator evaluator, String arguments) throws FunctionException {
        String result = "";

        try {
            String stringValue = new Evaluator().evaluate(arguments, true, false);
            stringValue = FunctionHelper.trimAndRemoveQuoteChars(
                    stringValue, evaluator.getQuoteCharacter());

            String[] arrayArgument = stringValue.split("`");

            String condition = evaluator.evaluate(arrayArgument[0]);
            if(Double.parseDouble(condition) > 0) {
                result = arrayArgument[1];
            } else {
                result = evaluator.evaluate(arrayArgument[2]);
            }
        } catch (EvaluationException ee) {
            throw new FunctionException("Invalid expression in arguments.", ee);
        } catch (Exception e) {
            throw new FunctionException("One string argument is required.", e);
        }

        return new FunctionResult(result, FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
    }

}
