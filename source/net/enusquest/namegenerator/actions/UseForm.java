package net.enusquest.namegenerator.actions;

import org.apache.struts.action.ActionForm;

public class UseForm extends ActionForm {
	String marked = "false";

	public String getMarked() {
		return marked;
	}

	public void setMarked(String newMarked) {
		marked = newMarked;
	}

}