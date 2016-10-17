/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kris Hayes
 */

@SessionScoped
@ManagedBean(name="creditcard")
public class CreditCardValidator implements Serializable{
    
    private String userNameFirst;
    private String userNameLast;
    private String userStreetAddress;
    private String userCity;
    private String userState;
    private Long userZipCode;
    private Long userCardNumber;
    private Long userExpMonth;
    private Long userExpYear;
    private Long userCvv;
    private String result;

    public CreditCardValidator() {
    }
    
    public void checkCard(){
        
        String line;
      
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\Computer_Programming\\CreditCardForm\\creditcards.csv"))) {
            boolean infoFound = false;
            
            while((line = br.readLine()) != null) {
                String[] cardInfo = line.split(",");
                if(cardInfo[0].toLowerCase().equals( userNameFirst) 
                    && cardInfo[1].equals(userNameLast)
                    && cardInfo[2].equals(userStreetAddress)
                    && cardInfo[3].equals(userCity)
                    && cardInfo[4].equals(userState)
                    && cardInfo[5].equals(userZipCode)
                    && cardInfo[6].equals(userCardNumber)
                    && cardInfo[7].equals(userExpMonth)
                    && cardInfo[8].equals(userExpYear)
                    && cardInfo[9].equals(userCvv)
                ){
                    infoFound = true;
                }
            }
            
            if(infoFound){
            	setResult("Confirmed. Credit Card information matches the database.");
            } else {
                setResult("Credit Card information is invalid. Credit Card does not match database."); 
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
 


    
    
    
    
    //Getters and Setters
    public String getUserNameFirst() {
        return userNameFirst;
    }

    public void setUserNameFirst(String userNameFirst) {
        this.userNameFirst = userNameFirst;
    }

    public String getUserNameLast() {
        return userNameLast;
    }

    public void setUserNameLast(String userNameLast) {
        this.userNameLast = userNameLast;
    }

    public String getUserStreetAddress() {
        return userStreetAddress;
    }

    public void setUserStreetAddress(String userStreetAddress) {
        this.userStreetAddress = userStreetAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Long getUserZipCode() {
        return userZipCode;
    }

    public void setUserZipCode(Long userZipCode) {
        this.userZipCode = userZipCode;
    }

    public Long getUserCardNumber() {
        return userCardNumber;
    }

    public void setUserCardNumber(Long userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    public Long getUserExpMonth() {
        return userExpMonth;
    }

    public void setUserExpMonth(Long userExpMonth) {
        this.userExpMonth = userExpMonth;
    }
    
    public Long getUserExpYear() {
        return userExpYear;
    }

    public void setUserExpYear(Long userExpYear) {
        this.userExpYear = userExpYear;
    }
    

    public Long getUserCvv() {
        return userCvv;
    }

    public void setUserCvv(Long userCvv) {
        this.userCvv = userCvv;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
}
