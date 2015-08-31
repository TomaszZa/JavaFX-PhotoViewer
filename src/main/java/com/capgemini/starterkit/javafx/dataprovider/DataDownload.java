package com.capgemini.starterkit.javafx.dataprovider;

import javafx.scene.image.WritableImage;

public interface DataDownload {
	public void inicjalizePictures(String path);

	public WritableImage nextPicture();

	public WritableImage previousPicture();

	public WritableImage firstPicture();

}
