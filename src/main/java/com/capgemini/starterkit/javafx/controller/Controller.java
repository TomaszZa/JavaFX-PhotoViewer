package com.capgemini.starterkit.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.capgemini.starterkit.javafx.dataprovider.impl.DataDownloadImpl;
import com.capgemini.starterkit.javafx.model.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {
	private static final Logger LOG = Logger.getLogger(Controller.class);

	private final Model model = new Model();
	private final DataDownloadImpl dataDownload = new DataDownloadImpl();

	@FXML
	ResourceBundle resources;

	@FXML
	URL location;

	@FXML
	Button left;

	@FXML
	ImageView imageToShow;

	@FXML
	Button right;

	@FXML
	TextField sourceField;

	@FXML
	Button addSource;

	public Controller() {
		LOG.debug("Controller constructed");
	}

	@FXML
	private void initialize() {
		LOG.debug("Inicjalization of Binding");

		sourceField.textProperty().bindBidirectional(model.pathProperty());
		addSource.disableProperty().bind(sourceField.textProperty().isEmpty());
	}

	@FXML
	public void leftButtoClict(ActionEvent event) {
		LOG.debug("Left Button Clicked");

		model.setImage(dataDownload.previousPicture());
		imageToShow.setImage(model.getImage());

	}

	@FXML
	public void rightButtonClict(ActionEvent event) {
		LOG.debug("Right Button Clicked");
		model.setImage(dataDownload.nextPicture());
		imageToShow.setImage(model.getImage());
	}

	@FXML
	public void sourceAdded(ActionEvent event) {
		LOG.debug("Source Folder Added with path " + model.getPath());
		dataDownload.inicjalizePictures(model.getPath());
		model.setImage(dataDownload.firstPicture());
		imageToShow.setImage(model.getImage());
	}

}
