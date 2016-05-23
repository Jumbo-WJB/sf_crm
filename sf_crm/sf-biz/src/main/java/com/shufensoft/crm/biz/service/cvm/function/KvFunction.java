package com.shufensoft.crm.biz.service.cvm.function;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.*;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-05 12:34  
 */
public class KvFunction implements Function {

    @Override
    public String getName() {
        return "kv";
    }

    /**
     * 键值对方法，以^分隔，键值之间以`分隔，第一个为需要取值的key，后面的都是kv，kv之间以`分隔
     *
     * @param evaluator
     * @param arguments
     * @return
     * @throws FunctionException
     */
    @Override
    public FunctionResult execute(Evaluator evaluator, String arguments) throws FunctionException {
        Integer result = null;

        try {
            String stringValue = new Evaluator().evaluate(arguments, true, false);
            stringValue = FunctionHelper.trimAndRemoveQuoteChars(stringValue, evaluator.getQuoteCharacter());

            String[] arrayArgument = stringValue.split("\\^");

            Map<Integer, Integer> mapValue = new HashMap<Integer, Integer>();
            Integer firstValue = null;
            Integer lastValue = null;
            for(int i=1; i<arrayArgument.length; i++) {
                String str = arrayArgument[i];
                String[] strArr = str.split("`");
                mapValue.put(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));

                if(i == 1) {
                    firstValue = Integer.parseInt(strArr[1]);
                }
                if(i == arrayArgument.length - 1) {
                    lastValue = Integer.parseInt(strArr[1]);
                }
            }

            Integer param = (int) Math.floor(Double.parseDouble(arrayArgument[0]));
            result = mapValue.get(param);

            if(result == null) {
                if(param <= 0) {
                    result = firstValue;
                } else {
                    result = lastValue;
                }
            }

        } catch (EvaluationException ee) {
            throw new FunctionException("Invalid expression in arguments.", ee);
        } catch (Exception e) {
            throw new FunctionException("One string argument is required.", e);
        }

        return new FunctionResult(String.valueOf(result), FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
    }

}
