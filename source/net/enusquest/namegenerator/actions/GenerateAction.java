package net.enusquest.namegenerator.actions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enusquest.namegenerator.NameFileReader;
import net.enusquest.namegenerator.NameGenerator;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GenerateAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String combinationName = ((GenerateForm) form).getCombinationName();
		String uniqueness = ((GenerateForm) form).getUniqueness();
		int predictability = ((GenerateForm) form).getPredictability();
		int tries = ((GenerateForm) form).getTries();
		int count = ((GenerateForm) form).getCount();

		count = count > 0 ? count : 1;

		if (combinationName != null && uniqueness != null && count >= 0) {
			Set names = new NameFileReader(combinationName).getNames();
			List generatedNames = new ArrayList();

			count : for (int i = 0; i < count; i++) {
				for (int p = predictability; p >= 0; p--) {
					NameGenerator generator = new NameGenerator(names, p);
					int triesCounter = tries;
					do {
						String name = generator.generate();
						triesCounter--;
						if ((uniqueness.equals("history") && (!names.contains(
								name) && !generatedNames
								.contains(name)))
								|| (uniqueness.equals("local") && !generatedNames
										.contains(name))
								|| (uniqueness.equals("none"))) {
							generatedNames.add(name);
							continue count;
						}
					} while (triesCounter > 0);
				}
			}

			Collections.sort(generatedNames);
			request.setAttribute("names", generatedNames);
		}

		List lists = new ArrayList();
		Properties props = new Properties();
		InputStream is = NameGenerator.class.getResourceAsStream(
				"NameGenerator.properties");

		try {
			props.load(is);
			String listsProperty = props.getProperty("lists");
			StringTokenizer tokenizer = new StringTokenizer(listsProperty, " ,");

			while (tokenizer.hasMoreTokens()) {
				lists.add(tokenizer.nextToken());
			}

			request.setAttribute("lists", lists);
		} catch (IOException ioex) {
			// Do nothing
		}

		return mapping.findForward("display");
	}

	public static void main(String[] args) {
		new GenerateAction().perform(null, null, null, null);
	}
}