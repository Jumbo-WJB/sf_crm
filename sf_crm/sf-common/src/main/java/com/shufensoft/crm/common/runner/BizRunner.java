package com.shufensoft.crm.common.runner;

import com.shufensoft.crm.common.runner.exception.BizRunnerException;
import com.shufensoft.crm.common.runner.executor.BizExecutor;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 业务异步执行器
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/6  
 */
public class BizRunner{

  public BizRunner(BizExecutor bizExecutor){
      this.bizExecutor = bizExecutor;
      this.bizThread = new Thread(new BizThread());
  }

  private Thread bizThread;

  private BizExecutor bizExecutor;


  public void start(){
    this.bizThread.start();
  }

  private class BizThread implements Runnable{
      @Override
      public void run() {
          if(bizExecutor == null){
            throw new BizRunnerException("bizExecutor is null");
          }
          bizExecutor.execute();
      }
  }


}
