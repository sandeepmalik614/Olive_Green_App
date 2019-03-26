package idi_olive_green_fetch_images;

public class Product{

  public String id;
  public String title;
  public String img_url;


  public Product(String p_title, String p_img_url) {
      title = p_title;
      img_url = p_img_url;
  }
  
  public String getImageUrl() {
		return img_url;
	}

	public void setImage(String image_url) {
		this.img_url = image_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
