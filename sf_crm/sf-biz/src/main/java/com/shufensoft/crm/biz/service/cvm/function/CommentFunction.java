package com.shufensoft.crm.biz.service.cvm.function;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.*;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-06 19:49  
 */
public class CommentFunction implements Function {

    @Override
    public String getName() {
        return "comment";
    }

    /**
     * 计算评价分数，不同评价以^分隔
     *
     * @param evaluator
     * @param arguments
     * @return
     * @throws FunctionException
     */
    @Override
    public FunctionResult execute(Evaluator evaluator, String arguments) throws FunctionException {
        Integer result = 0;

        try {
            String stringValue = new Evaluator().evaluate(arguments, true, false);
            stringValue = FunctionHelper.trimAndRemoveQuoteChars(stringValue, evaluator.getQuoteCharacter());

            String[] arrComment = stringValue.split("\\^");

            for(int i=0; i<arrComment.length; i++) {
                int score = 0;
                String comment = arrComment[i];
                if(comment.length() <= 5) {
                    score = 1;
                } else if(comment.length() <= 10) {
                    score = 2;
                } else if(comment.length() <= 15) {
                    score = 4;
                } else if(comment.length() <= 20) {
                    score = 8;
                } else {
                    score = 16;
                }

                result += 4 * score;

                if(result >= 100) {
                    break;
                }
            }

            if(result > 100) {
                result = 100;
            }
        } catch (EvaluationException ee) {
            throw new FunctionException("Invalid expression in arguments.", ee);
        } catch (Exception e) {
            throw new FunctionException("One string argument is required.", e);
        }

        return new FunctionResult(String.valueOf(result), FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
    }

}
