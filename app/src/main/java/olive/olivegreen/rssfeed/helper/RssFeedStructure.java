package olive.olivegreen.rssfeed.helper;

import android.util.Log;

public class RssFeedStructure {

private long articleId;
private long feedId;
private String title;
private String description;
private String imgLink;
private String pubDate;
//private URL url;
private String url;
private String encodedContent;
String[] new_img;
String new_img_link;

public long getArticleId() {
return articleId;
}

public void setArticleId(long articleId) {
this.articleId = articleId;
}

public long getFeedId() {
return feedId;
}
/**
* @param feedId the feedId to set
*/
public void setFeedId(long feedId) {
this.feedId = feedId;
}
/**
* @return the title
*/
public String getTitle() {
return title;
}
/**
* @param title the title to set
*/
public void setTitle(String title) {
this.title = title;
}
/**
*/
//public URL getUrl() {
public String getUrl() {
return url;
}
/**
* @param url the url to set
*/
public void setUrl(String url) {
this.url = url;
}
/**
* @param description the description to set
*/
public void setDescription(String description) {
this.description = description;


if (description.contains("<img ")){
String img = description.substring(description.indexOf("<img "));
String cleanUp = img.substring(0, img.indexOf(">")+1);
img = img.substring(img.indexOf("src=") + 5);
int indexOf = img.indexOf("'");
if (indexOf==-1){
indexOf = img.indexOf("\"");
}
img = img.substring(0, indexOf);
new_img = img.split("\" />");

new_img_link = new_img[0];
System.out.println("Image :"+img);
System.out.println("New Image :"+new_img_link );

imgLink = new_img_link;

//setImgLink(new_img_link);

this.description = this.description.replace(cleanUp, "");
}
}
/**
* @return the description
*/
public String getDescription() {
return description;
}
/**
* @param pubDate the pubDate to set
*/
public void setPubDate(String pubDate) {
this.pubDate = pubDate;
}
/**
* @return the pubDate
*/
public String getPubDate() {
return pubDate;
}
/**
* @param encodedContent the encodedContent to set
*/
public void setEncodedContent(String encodedContent) {
this.encodedContent = encodedContent;
}
/**
* @return the encodedContent
*/
public String getEncodedContent() {
return encodedContent;
}
/**
* @param imgLink the imgLink to set
*/
public void setImgLink(String imgLink) {
	
 	Log.e("IMG Link in Set Method", "Image Link" +imgLink);
this.imgLink = imgLink;
}
/**
* @return the imgLink
*/
public String getImgLink() {
	 
return imgLink;
}

}


