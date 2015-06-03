package com.rsk.mehar.helper;

import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.operations.AllOperation;
import com.rsk.mehar.persistance.operations.CardentialOperations;
import com.rsk.mehar.persistance.pojo.User;
import com.rsk.mehar.persistance.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Created by ravinder on 04-06-2015.
 */
public class LoginHandler {
    private static final Logger LOGGER = Logger.getLogger(LoginHandler.class);
    //from request
    private static final String USER_NAME_KEY="userName";
    private static final String PASSWORD_KEY="password";

    //for response
    private static final String STATUS="status";
    private static final String MESSAGE="message";

    public JSONObject doLogin(HttpServletRequest request)
    {
        JSONObject jsonRequest = getJsonObjectFromRequest(request);
        JSONObject jsonResponse = new JSONObject();
        AllOperation operations = new AllOperation();
        String email = (String)jsonRequest.get(USER_NAME_KEY);
        if (operations.isUserExist(email))
        {
            String password = ((String)jsonRequest.get(PASSWORD_KEY)).trim();
            LOGGER.warn("password is : "+password);
            if(operations.isValidCardentials(email,password))
            {
                System.err.print("success");
                jsonResponse.put(STATUS,"true");
                jsonResponse.put(MESSAGE, "success");
                User user = operations.getUser(email);
                jsonResponse.put(USER_NAME_KEY, user !=null?user.getFirstName()+" "+user.getLastName():"");
            }
            else
            {
                System.err.print("failure");
                jsonResponse.put(STATUS,"false");
                jsonResponse.put(MESSAGE,"Password is wrong !");
            }
        }
        else
        {
            jsonResponse.put(STATUS,"false");
            jsonResponse.put(MESSAGE,"LoginId not registered !");
        }
        return jsonResponse;
    }

    private JSONObject getJsonObjectFromRequest(HttpServletRequest request) {

        StringBuffer sb = new StringBuffer();

        try {
            BufferedReader reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JSONObject) JSONValue.parse(sb.toString());
    }
}
