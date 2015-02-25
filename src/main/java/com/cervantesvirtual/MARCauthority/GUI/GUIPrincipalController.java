/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cervantesvirtual.MARCauthority.GUI;


import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Impact
 */
public class GUIPrincipalController
{
    
    @FXML
    BorderPane panelPrincipal;
    
    private MARCAuthorityGUI mainApp = null;
    
    
    public void setMainApp(MARCAuthorityGUI main)
    {
        mainApp = main;
    }
    
    public void setCenterPane(Node content)
    {
        panelPrincipal.setCenter(content);
    }
    
    @FXML
    private void setAuthDir()
    {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(mainApp.getRootStage());
        
        if (selectedDirectory != null)
        {
            mainApp.setAuthoDirIn(selectedDirectory);
        }            
    }
    
    @FXML
    private void nextField()
    {
        mainApp.sigField();
        mainApp.setToggleDefault();
    }
    
    @FXML
    private void buttonSave()
    {
        mainApp.saveAuthority();
    }
    
    @FXML
    private void openAuth()
    {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Authority File");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("XML Files", "*.xml"));
        final File selectedFile = fileChooser.showOpenDialog(mainApp.getRootStage());
        
        if (selectedFile != null)
        {
            mainApp.openAuth(selectedFile);
        }            
        
    }
    
}
