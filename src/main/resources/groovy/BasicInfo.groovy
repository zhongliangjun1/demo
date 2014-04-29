package groovy

import com.dianping.wizard.ResultType
import com.dianping.wizard.WidgetBusiness

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-29
 * Time: PM7:45
 * To change this template use File | Settings | File Templates.
 */
class BasicInfo extends WidgetBusiness {

    @Override
    protected ResultType execute() {
        println('execute BasicInfo');

        if (params){
            params.each {
                println('key:'+it.key+' value:'+it.value)
            }
        }

        return ResultType.SUCCESS;
    }


}
