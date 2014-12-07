/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.pojo;

import java.util.Date;

public class Cardential
{
    private String email;
    private String password;
    private Date lastChange;
    private Date expiryDate;
    
    public Cardential(String email, String password, Date lastChange, Date expiryDate)
    {
        this.email = email;
        this.password = password;
        this.lastChange = lastChange;
        this.expiryDate = expiryDate;
    }
    
    public Cardential()
    {
        // TODO Auto-generated constructor stub
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Date getLastChange()
    {
        return lastChange;
    }
    
    public void setLastChange(Date lastChange)
    {
        this.lastChange = lastChange;
    }
    
    public Date getExpiryDate()
    {
        return expiryDate;
    }
    
    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */