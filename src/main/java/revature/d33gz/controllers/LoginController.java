package revature.d33gz.controllers;

import io.javalin.http.Handler;

public class LoginController {
	public static Handler verification = ctx -> {
		System.out.println(ctx.sessionAttributeMap());
		int currentId = ctx.sessionAttribute("ID");
		if (ctx.sessionAttributeMap().size() == 0 || currentId == -1)
			ctx.redirect("/pages/failure.html");
		else {
			if (ctx.contextPath("/pages/employeePage.html"))
				ctx.redirect("/pages/employeePage.html");
		}
	};
}
