package com.liferay.portal.login.custom;

import com.liferay.portal.kernel.events.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomPostLoginAction extends Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomPostLoginAction.class);
    private static String fileName = "assertiontholder.ser";

    public void run(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("### CUSTOM POST LOGIN ACTION");
        HttpSession session = request.getSession();
        String USER_samlResponseXML = (String) request.getAttribute("USER_samlResponseXML");
        session.setAttribute("USER_samlResponseXML", USER_samlResponseXML);
    }
}
