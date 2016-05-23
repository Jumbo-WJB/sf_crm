package com.shufensoft.crm.biz.service.cvm;

import com.shufensoft.crm.biz.service.cvm.function.CommentFunction;
import com.shufensoft.crm.biz.service.cvm.function.IfThenElseFunction;
import com.shufensoft.crm.biz.service.cvm.function.KvFunction;
import lombok.Getter;
import lombok.Setter;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import org.apache.log4j.Logger;

/**
 *  客户价值模型维度
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang chenqiang@shufensoft.com
 *  @date 2015-05-14 14:18  
 */
public class CvmDimComputor {

    private static final Logger logger = Logger.getLogger(CvmDimComputor.class);

    /**
     * Constructor
     *
     * @param name 维度名
     * @param cvmDimTypeEnum 维度类型
     * @param expression 维度计算公式
     * @param coefficient 维度系数
     */
    public CvmDimComputor(String name, CvmDimTypeEnum cvmDimTypeEnum, String expression, double coefficient) {
        this.evaluator = new Evaluator();
        this.name = name;
        this.cvmDimTypeEnum = cvmDimTypeEnum;
        this.expression = expression;
        this.coefficient = coefficient;
        this.evaluator.putFunction(new IfThenElseFunction());
        this.evaluator.putFunction(new KvFunction());
        this.evaluator.putFunction(new CommentFunction());
    }

    private Evaluator evaluator = null;

    @Getter @Setter
    private String name = null;

    @Getter @Setter
    private CvmDimTypeEnum cvmDimTypeEnum;

    // 由原始值到目标值转换的函数
    @Getter @Setter
    private String expression = null;

    // 维度系数
    @Getter @Setter
    private double coefficient = 0d;

    public double compute(Object... dimRawValue) throws EvaluationException {
        if(expression.indexOf("param1") >= 0) {
            evaluator.putVariable("param1", String.valueOf(dimRawValue[0]));
        }
        if(expression.indexOf("param2") >= 0) {
            evaluator.putVariable("param2", String.valueOf(dimRawValue[1]));
        }
        if(expression.indexOf("param3") >= 0) {
            evaluator.putVariable("param3", String.valueOf(dimRawValue[2]));
        }

        try {
            String result = evaluator.evaluate(expression);
            return Double.parseDouble(result) * coefficient;
        } catch (EvaluationException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public static void  main(String[] args) throws EvaluationException {
//        CvmDimComputor cvmDimComputor = new CvmDimComputor();
//        cvmDimComputor.setName("最近一次购买时间");
//        cvmDimComputor.setCoefficient(0.9d);
//        cvmDimComputor.setCvmDimTypeEnum(CvmDimTypeEnum.GLOBAL);
//        cvmDimComputor.setExpression("#{param1}  + 1");
//        System.out.println(cvmDimComputor.compute(1.0d));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate("#{E}");
        System.out.println(result);
    }

}
