import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;


final class ArticleItemsContract {

    //The authority of the provider.
    public static final String AUTHORITY =
            "de.openminds.samples.cpsample.articleitems";

     //The content URI for the top-level authority
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public void ArticleItemsContract(Context context) {

    }

    //Constants for the ArticleItems table of the provider
    public static final class Items
            implements CommonColumns {
        //The content URI for ArticleItems table
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(ArticleItemsContract.CONTENT_URI,
                        "articles");
        //mime type of directory of items
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                        "/vnd.de.openminds.articleitems_articles";

        //mime type of a single item.
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.de.openminds.articleitems_articles";

    }

    //defines common columns found in multiple tables
    public static interface CommonColumns
            extends BaseColumns {
    }
}
