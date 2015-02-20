package com.cervantesvirtual.MARCauthority.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cervantesvirtual.MARCauthority.AuthorityField;
import com.cervantesvirtual.MARCauthority.AuthorityRecord;
import com.cervantesvirtual.MARCauthority.AuthorityType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Impact
 */
public class AuthorsViewController
{
    @FXML
    Label establishedName;
    @FXML
    Label establishedTitle;
    @FXML
    Label establishedPeriod;
    @FXML
    Label candidateName;
    @FXML
    Label candidateTitle;
    @FXML
    Label candidatePeriod;
    @FXML
    ToggleGroup candidate;
    @FXML
    ToggleButton buttonError;
    @FXML
    ToggleButton buttonEstablished;
    @FXML
    ToggleButton buttonVariant;

    
    
    private MARCAuthorityGUI mainApp = null;

    public void setCandidateContent(AuthorityField candidate)
    {
        candidateName.setText(candidate.getName());
        candidateTitle.setText(candidate.getTitle());
        candidatePeriod.setText(candidate.getOriginalDate());
    }
    
     public void setEstablishedContent(AuthorityRecord estrablished)
    {
        //TODO sacar campos
        
        //candidateName.setText(candidate.getName());
        //candidateTitle.setText(candidate.getTitle());
        //candidatePeriod.setText(candidate.getOriginalDate());
    }

    public void setMainApp(MARCAuthorityGUI main)
    {
        mainApp = main;
    }
    
    @FXML
    void initialize()
    {
        candidateName.setText("");
        candidateTitle.setText("");
        candidatePeriod.setText("");
        
        buttonEstablished.setUserData(AuthorityType.ESTABLISHED);
        buttonVariant.setUserData(AuthorityType.VARIANT);
        buttonError.setUserData(AuthorityType.ERROR);       
        
    }
    
    public AuthorityType getToggleSelected()
    {
        if (candidate.getSelectedToggle() != null)
        {
            return (AuthorityType) candidate.getSelectedToggle().getUserData();
        }
        else
        {
            return null;
        }
    }

}
