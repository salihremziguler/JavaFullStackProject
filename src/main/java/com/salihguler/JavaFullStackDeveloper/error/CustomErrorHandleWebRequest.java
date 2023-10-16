package com.salihguler.JavaFullStackDeveloper.error;

import com.salihguler.JavaFullStackDeveloper.assist.FrontendUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

//Error Controler
//Error attribute
//WebRequest


@Log4j2

//Srping Boot defaulttan gelen error!ı kendimize göre customise yapıyoruz
@RestController
@CrossOrigin(origins = FrontendUrl.REACT_URL)  //Farklı portlar arasında geçiş yapmak istenildiğinde Localhost 300 portunu backendde kullanabiliriz.
@RequiredArgsConstructor
public class CustomErrorHandleWebRequest implements ErrorController {

    //Enjekte Ederken
    //1.yol (Field Injektion)
    //@Autowired
   /* private ErrorAttributes errorAttributes;

    //2.Yol Constructor Injection
    @Autowired
    public CustomErrorHandleWebRequest(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }*/


    //3.Yol (Lombok Injection)
    private final ErrorAttributes errorAttributes;

    private int status;
    private String path;
    private String message;
    private ApiResult apiResult;
   private Map<String,String> validationErrors;

   //hhttp://localhost:4444/error
   @RequestMapping("/error")
    public ApiResult handleErrorMethod(WebRequest webRequest)
    {
        //Spring 2.3 den sonra
        Map<String, Object> attributes=errorAttributes.getErrorAttributes(
                webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS)
        ); //end Attribute


        //Springden verileri almak
        status=(int)attributes.get("status");
        message=(String) attributes.get("message");
        path=(String)attributes.get("path");
        apiResult=new ApiResult(status,path,message);

       if(attributes.containsKey("errors"))
       {
           List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("error");
            Map<String,String> validationMistake=new HashMap<>();

            //forEach döngü
           for(FieldError fieldError:fieldErrorList)
           {
               validationMistake.put(fieldError.getField(),fieldError.getDefaultMessage());

           }
           apiResult.setValidationErrors(validationErrors);


       }


        return apiResult;
    }








}
