package com.capgemini.starterkit.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.WritableImage;

public class Model {
	private final StringProperty path = new SimpleStringProperty();
	private WritableImage image;

	public final String getPath() {
		return path.get();
	}

	public final void setPath(String path) {
		this.path.set(path);
	}

	public StringProperty pathProperty() {
		return path;
	}

	public final WritableImage getImage() {
		return image;
	}

	public final void setImage(WritableImage image) {
		this.image = image;
	}
}
