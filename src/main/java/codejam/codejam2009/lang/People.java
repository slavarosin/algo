package codejam.codejam2009.lang;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class People {
	class Guy {
		String name;
		List<String> skills = new ArrayList<String>();
	}

	private List<Guy> guys;

	public People() {
		guys = new ArrayList<People.Guy>();
		guys.add(newGuy("Misha", "Java", "AngularJS", "JMS", "REST",
				"WebServices", "Hibernate", "MySQL", "C++", "C#", "ObjectiveC",
				"Silverlight", "QT", "Spring", "ActiveMQ"));
		guys.add(newGuy("Dima", "Java", "AngularJS", "JMS", "REST",
				"WebServices", "Hibernate", "MySQL", "Android", "Spring",
				"ActiveMQ"));
		guys.add(newGuy("Aleksei", "Java", "J2EE", "C++", "C#", "ERP",
				"Python", "MySQL", "Spring", "REST"));
		guys.add(newGuy("Alexander", "Rx.js", "Oracle", "Twitter Bootstrap",
				"Knockout.js", "Java", "C++", "XSLT", "PHP", "MySQL", "QUnit",
				"jQuery", "jQuery UI", "SlickGrid", "Drupal", "Yii", "PhpUnit",
				"XSLT", "RequireJS", "Underscore.js", "JavaScript", "Mocha.js"));
		guys.add(newGuy("Max", "Java", "Rx.js", "Twitter Bootstrap", "PHP",
				"MySQL", "Python", "RequireJS", "Underscore.js", "JavaScript",
				"Mocha.js", "Selenium"));
		guys.add(newGuy("Roma", "Java", "AngularJS", "C", "C++", "EJB",
				"PostgreSQL", "JPA", "Spring", "REST"));
		guys.add(newGuy("Grisha", "JavaScript", "ExtJS", "UX", "AngularJS",
				"PHP", "Flash", "Backbone.js"));
		guys.add(newGuy("Treush", "iOS", "ObjectiveC", "RestKit", "OpenGL"));
		guys.add(newGuy("Anton", "JavaScript", "Delphi", "PHP", "MongoDB",
				"MySQL"));
	}

	@Override
	public String toString() {
		HashMap<String, Integer> bySkill = new HashMap<String, Integer>();
		for (Guy guy : guys) {
			for (String skill : guy.skills) {
				Integer count = bySkill.get(skill);
				if (count == null) {
					count = 0;
				}
				count++;
				bySkill.put(skill, count);
			}
		}

		SortedSet<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o2, String o1) {
				int byValue = new Integer(o1.split("[:]")[1].trim())
						.compareTo(new Integer(o2.split("[:]")[1].trim()));
				if (byValue != 0)
					return byValue;
				return o1.compareTo(o2);
			}
		});
		for (String skill : bySkill.keySet()) {
			set.add(skill + ": " + bySkill.get(skill));
		}

		String s = "";
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String string = (String) iter.next();
			s += string + "\n";
		}

		return s;
	}

	public static void main(String[] in) throws IOException {
		System.out.println(new People());
	}

	private Guy newGuy(String name, String... skills) {
		Guy guy = new Guy();
		guy.name = name;
		guy.skills.addAll(asList(skills));
		return guy;
	}
}
