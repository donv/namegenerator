package net.enusquest.namegenerator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GenerateAction extends Action {

  /**
   * Constructor for GenerateAction
   */
  public GenerateAction() {
    super();
  }

  public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) {

    return mapping.findForward("input");
  }

}