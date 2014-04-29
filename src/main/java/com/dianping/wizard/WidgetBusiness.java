package com.dianping.wizard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-29
 * Time: PM7:19
 * To change this template use File | Settings | File Templates.
 */
public abstract class WidgetBusiness implements WidgetParamsAware, WidgetServicesAware {

    protected Map<String, Object> params;
    protected Map<String, Object> services;

    protected final Map<String, Object> resultModel = new HashMap<String, Object>();

    protected abstract ResultType execute();

    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getServices() {
        return services;
    }

    @Override
    public void setServices(Map<String, Object> services) {
        this.services = services;
    }

    /**
     * model for the render view
     * @return
     */
    public Map<String, Object> getResultModel() {
        return resultModel;
    }

}
