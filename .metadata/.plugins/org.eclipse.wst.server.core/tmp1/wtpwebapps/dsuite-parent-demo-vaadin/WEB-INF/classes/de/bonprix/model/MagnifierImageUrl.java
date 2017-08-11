package de.bonprix.model;

public class MagnifierImageUrl {

	private static final String IMAGE_URL_FRONT = "http://rfp.laudert.de/previews/assets/";
	private static final String IMAGE_SIZE = "prev_m/";
	private static final String IMAGE_SIZE_ZOOM = "prev_l/";

	private String imageUrlEnd = null;

	public MagnifierImageUrl(String imageUrlEnd) {
		this.imageUrlEnd = imageUrlEnd;
	}

	public String getImageUrl() {
		return MagnifierImageUrl.IMAGE_URL_FRONT + MagnifierImageUrl.IMAGE_SIZE + this.imageUrlEnd;
	}

	public String getImageZoomUrl() {
		return MagnifierImageUrl.IMAGE_URL_FRONT + MagnifierImageUrl.IMAGE_SIZE_ZOOM + this.imageUrlEnd;
	}

}
