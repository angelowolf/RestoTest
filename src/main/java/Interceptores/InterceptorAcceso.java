/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptores;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ang_2
 */
public class InterceptorAcceso extends AbstractInterceptor {

    private String actionsPublicos;
    private List<String> actionsSinFiltrar = new ArrayList<>();

    @Override
    public void init() {
        actionsSinFiltrar = Arrays.asList(actionsPublicos.split(","));
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result = Action.LOGIN;
        String actionActual = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);

        //Si es una accion publica se ejecuta
        if (actionsSinFiltrar.contains(actionActual)) {
            return actionInvocation.invoke();
        } else if (!actionInvocation.getInvocationContext().getSession().containsKey("idUsuario")) {
            //si entra aca es que esta intentando acceder a una ruta en la que tiene que estar logeado y no lo esta
            return result;
        } else {
            if (actionInvocation.getInvocationContext().getSession().containsKey("primeraVez")) {
                if (actionActual.equals("primerLogin")) {
                    return actionInvocation.invoke();
                }
                return result;
            }
            //esta logeado ver si tiene el privilegio
            String namespace = actionInvocation.getProxy().getNamespace();
            String[] namespace1 = namespace.split("\\/");
            if (namespace1.length > 0) {
                switch (namespace1[1]) {
                    //switch de los namespaces
                    case "usuario":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolUsuario")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolUsuario");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    case "stock":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolStock")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolStock");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    case "insumo":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolStock")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolStock");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    case "insumobruto":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolStock")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolStock");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    case "insumoelaborado":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolCocina")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolCocina");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    case "receta":
                        if (actionInvocation.getInvocationContext().getSession().containsKey("rolCocina")) {
                            boolean f = (boolean) actionInvocation.getInvocationContext().getSession().get("rolCocina");
                            if (f) {
                                return actionInvocation.invoke();
                            }
                        }
                        break;
                    default:
                        return actionInvocation.invoke();
                }
            } else {
                //esta en el namespace '/'
                return actionInvocation.invoke();
            }
        }
        return result;

    }

    public void setActionsPublicos(String actionsPublicos) {
        this.actionsPublicos = actionsPublicos;
    }
}
