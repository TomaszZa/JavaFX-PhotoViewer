package com.capgemini.starterkit.javafx.dataprovider.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.capgemini.starterkit.javafx.controller.Controller;
import com.capgemini.starterkit.javafx.dataprovider.DataDownload;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

public class DataDownloadImpl implements DataDownload {
	private static final Logger LOG = Logger.getLogger(Controller.class);
	private List<WritableImage> picturesList;
	private Integer index;

	public DataDownloadImpl() {
		picturesList = new ArrayList<WritableImage>();
		index = 0;
	}

	@Override
	public void inicjalizePictures(String path) {
		LOG.debug("Picture inicjalization");
		// File representing the folder that you select using a FileChooser
		final File dir = new File(path);

		// array of supported extensions (use a List if you prefer)
		final String[] EXTENSIONS = new String[] { "jpg", "PNG", "bmp" // and
																		// other
																		// formats
																		// you
																		// need
		};
		// filter to identify images based on their extensions
		final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

			@Override
			public boolean accept(final File dir, final String name) {
				for (final String ext : EXTENSIONS) {
					if (name.endsWith("." + ext)) {
						return (true);
					}
				}
				return (false);
			}
		};

		if (dir.isDirectory()) { // make sure it's a directory
			for (final File f : dir.listFiles(IMAGE_FILTER)) {
				BufferedImage img = null;

				try {
					img = ImageIO.read(f);
					picturesList.add(SwingFXUtils.toFXImage(img, null));

				} catch (final IOException e) {
					System.out.println(e);
				}
			}
		}

	}

	@Override
	public WritableImage nextPicture() {
		if (picturesList.size() == 0)
			return null;
		if (index == picturesList.size() - 1)
			return picturesList.get(index);
		return picturesList.get(++index);
	}

	@Override
	public WritableImage previousPicture() {
		if (picturesList.size() == 0)
			return null;
		if (index == 0)
			return picturesList.get(index);
		return picturesList.get(--index);
	}

	@Override
	public WritableImage firstPicture() {
		if (picturesList.size() == 0)
			return null;
		return picturesList.get(0);
	}

}
