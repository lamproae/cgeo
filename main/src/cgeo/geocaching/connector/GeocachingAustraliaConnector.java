package cgeo.geocaching.connector;

import cgeo.geocaching.models.Geocache;

import org.apache.commons.lang3.StringUtils;
import android.support.annotation.NonNull;

class GeocachingAustraliaConnector extends AbstractConnector {

    @Override
    @NonNull
    public String getName() {
        return "Geocaching Australia";
    }

    @Override
    @NonNull
    public String getCacheUrl(@NonNull final Geocache cache) {
        return getCacheUrlPrefix() + cache.getGeocode();
    }

    @Override
    @NonNull
    public String getHost() {
        return "geocaching.com.au";
    }

    @Override
    public boolean isOwner(@NonNull final Geocache cache) {
        return false;
    }

    @Override
    public boolean canHandle(@NonNull final String geocode) {
        return (StringUtils.startsWithIgnoreCase(geocode, "GA") || StringUtils.startsWithIgnoreCase(geocode, "TP")) && isNumericId(geocode.substring(2));
    }

    @Override
    @NonNull
    protected String getCacheUrlPrefix() {
        return getHostUrl() + "/cache/";
    }
}
