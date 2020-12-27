import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


class NewsContentProvider extends ContentProvider {
    private static final UriMatcher URI_MATCHER;
    // prepares the UriMatcher
    private static final UriMatcher mUriMatcher = NewsContentProvider.URI_MATCHER;
    private static final int ITEM_LIST = 1;
    private static final String DATABASE_NAME = "article_db";
    private RecyclerViewAdapter mDB;

    // For testing.
    public final static String AUTHORITY = "edu.vanderbilt.mooc.atom_reader.provider";
    // logging tag.
    private final static String LOG_TAG = NewsContentProvider.class.getCanonicalName();


    static {

        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(NewsContentProvider.AUTHORITY, "items", ITEM_LIST);
    }

    public NewsContentProvider(RecyclerViewAdapter mDB) {
        this.mDB = mDB;
    }


    @Override
    public boolean onCreate() {
        return true;
    }


    @Override
    public String getType(@NonNull Uri uri) {

        switch (URI_MATCHER.match(uri)) {
            case ITEM_LIST:
                return ArticleItemsContract.Items.CONTENT_TYPE;
            default:
                throw new IllegalArgumentException("Invalid URI");
        }
    }
   //uses SQLiteQueryBuilder to build query
    @Override
    synchronized public Cursor query(final Uri uri, final String[] projection,final String selection, final String[] selectionArgs, final String sortOrder) {
        Log.d(LOG_TAG, "query(...) Uri: " + uri);
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        //sets the tables to be queried upon
        return mDB.query(projection, selection, selectionArgs, sortOrder);

    }

   //to handle requests to insert (null), delete, update
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
