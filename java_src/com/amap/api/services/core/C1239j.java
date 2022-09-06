package com.amap.api.services.core;

import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Cinema;
import com.amap.api.services.poisearch.Dining;
import com.amap.api.services.poisearch.Discount;
import com.amap.api.services.poisearch.Groupbuy;
import com.amap.api.services.poisearch.Hotel;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.Scenic;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.fimi.soul.utils.C3670av;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.j */
/* loaded from: classes.dex */
public class C1239j {
    /* renamed from: a */
    public static Scenic m17017a(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Scenic scenic = new Scenic();
        scenic.setIntro(m17002b(jSONObject, "intro"));
        scenic.setRating(m17002b(jSONObject, "rating"));
        scenic.setDeepsrc(m17002b(jSONObject, "deepsrc"));
        scenic.setLevel(m17002b(jSONObject, "level"));
        scenic.setPrice(m17002b(jSONObject, "price"));
        scenic.setSeason(m17002b(jSONObject, "season"));
        scenic.setRecommend(m17002b(jSONObject, "recommend"));
        scenic.setTheme(m17002b(jSONObject, "theme"));
        scenic.setOrderWapUrl(m17002b(jSONObject, "ordering_wap_url"));
        scenic.setOrderWebUrl(m17002b(jSONObject, "ordering_web_url"));
        scenic.setOpentimeGDF(m17002b(jSONObject, "opentime_GDF"));
        scenic.setOpentime(m17002b(jSONObject, "opentime"));
        scenic.setPhotos(m16976l(jSONObject));
        poiItemDetail.setDeepType(PoiItemDetail.DeepType.SCENIC);
        poiItemDetail.setScenic(scenic);
        return scenic;
    }

    /* renamed from: a */
    public static ArrayList<SuggestionCity> m17010a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(m17002b(optJSONObject, "name"), m17002b(optJSONObject, "citycode"), m17002b(optJSONObject, "adcode"), m16983i(m17002b(optJSONObject, "num"))));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<BusPath> m17013a(JSONArray jSONArray) {
        BusStep m16971q;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(m16981j(m17002b(optJSONObject, "cost")));
                busPath.setDuration(m16979k(m17002b(optJSONObject, "duration")));
                busPath.setNightBus(m16977l(m17002b(optJSONObject, "nightflag")));
                busPath.setWalkDistance(m16981j(m17002b(optJSONObject, "walking_distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null && (m16971q = m16971q(optJSONObject2)) != null) {
                            arrayList2.add(m16971q);
                            if (m16971q.getWalk() != null) {
                                f += m16971q.getWalk().getDistance();
                            }
                            if (m16971q.getBusLine() != null) {
                                f2 += m16971q.getBusLine().getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f2);
                    busPath.setWalkDistance(f);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m17020a(Discount discount, JSONObject jSONObject) {
        discount.initPhotos(m16976l(jSONObject));
    }

    /* renamed from: a */
    public static void m17019a(Groupbuy groupbuy, JSONObject jSONObject) {
        groupbuy.initPhotos(m16976l(jSONObject));
    }

    /* renamed from: a */
    public static void m17018a(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (poiItemDetail.isGroupbuyInfo()) {
            m17007b(poiItemDetail, jSONObject);
        }
        if (!poiItemDetail.isDiscountInfo()) {
            return;
        }
        m17001c(poiItemDetail, jSONObject);
    }

    /* renamed from: a */
    public static void m17016a(DriveStep driveStep, JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(m17002b(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(m17002b(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(m17002b(optJSONObject, "adcode"));
                    m17015a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            C1233d.m17031a(e, "JSONHelper", "parseCrossCity");
        }
    }

    /* renamed from: a */
    public static void m17015a(RouteSearchCity routeSearchCity, JSONObject jSONObject) {
        if (!jSONObject.has("districts")) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                routeSearchCity.setDistricts(arrayList);
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                District district = new District();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    district.setDistrictName(m17002b(optJSONObject, "name"));
                    district.setDistrictAdcode(m17002b(optJSONObject, "adcode"));
                    arrayList.add(district);
                }
            }
            routeSearchCity.setDistricts(arrayList);
        } catch (JSONException e) {
            C1233d.m17031a(e, "JSONHelper", "parseCrossDistricts");
        }
    }

    /* renamed from: a */
    public static void m17012a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(m17002b(optJSONObject, "id"));
                crossroad.setDirection(m17002b(optJSONObject, "direction"));
                crossroad.setDistance(m16981j(m17002b(optJSONObject, "distance")));
                crossroad.setCenterPoint(m16997c(optJSONObject, "location"));
                crossroad.setFirstRoadId(m17002b(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(m17002b(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(m17002b(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(m17002b(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    /* renamed from: a */
    public static void m17011a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16975m(optJSONObject));
            }
        }
        if (districtItem == null) {
            return;
        }
        districtItem.setSubDistrict(arrayList);
    }

    /* renamed from: a */
    public static void m17009a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) {
        regeocodeAddress.setProvince(m17002b(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(m17002b(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(m17002b(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(m17002b(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(m17002b(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(m17002b(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(m17002b(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(m17002b(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(m17002b(optJSONObject, "street"));
        streetNumber.setNumber(m17002b(optJSONObject, "number"));
        streetNumber.setLatLonPoint(m16997c(optJSONObject, "location"));
        streetNumber.setDirection(m17002b(optJSONObject, "direction"));
        streetNumber.setDistance(m16981j(m17002b(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(m16972p(jSONObject));
    }

    /* renamed from: a */
    public static boolean m17014a(String str) {
        try {
            if (str.equals("")) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt != 0 && parseInt == 1;
        } catch (NumberFormatException e) {
            C1233d.m17031a(e, "JSONHelper", "ordingStr2Boolean");
            return false;
        } catch (Exception e2) {
            C1233d.m17031a(e2, "JSONHelper", "ordingStr2BooleanException");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m17008a(JSONObject jSONObject, String str) {
        return m17014a(m17002b(jSONObject.optJSONObject("biz_ext"), str));
    }

    /* renamed from: b */
    public static BusRouteResult m17005b(String str) {
        JSONArray optJSONArray;
        BusRouteResult busRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(C3670av.f14874a)) {
                busRouteResult = new BusRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject(C3670av.f14874a);
                if (optJSONObject != null) {
                    busRouteResult.setStartPos(m16997c(optJSONObject, "origin"));
                    busRouteResult.setTargetPos(m16997c(optJSONObject, "destination"));
                    busRouteResult.setTaxiCost(m16981j(m17002b(optJSONObject, "taxi_cost")));
                    if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                        busRouteResult.setPaths(m17013a(optJSONArray));
                    }
                }
            }
            return busRouteResult;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: b */
    public static String m17002b(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    /* renamed from: b */
    public static ArrayList<String> m17003b(JSONObject jSONObject) {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m17007b(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("groupbuys")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Groupbuy groupbuy = new Groupbuy();
                groupbuy.setTypeCode(m17002b(optJSONObject, "typecode"));
                groupbuy.setTypeDes(m17002b(optJSONObject, "type"));
                groupbuy.setDetail(m17002b(optJSONObject, "detail"));
                groupbuy.setStartTime(C1233d.m17027c(m17002b(optJSONObject, "start_time")));
                groupbuy.setEndTime(C1233d.m17027c(m17002b(optJSONObject, "end_time")));
                groupbuy.setCount(m16983i(m17002b(optJSONObject, "num")));
                groupbuy.setSoldCount(m16983i(m17002b(optJSONObject, "sold_num")));
                groupbuy.setOriginalPrice(m16981j(m17002b(optJSONObject, "original_price")));
                groupbuy.setGroupbuyPrice(m16981j(m17002b(optJSONObject, "groupbuy_price")));
                groupbuy.setDiscount(m16981j(m17002b(optJSONObject, "discount")));
                groupbuy.setTicketAddress(m17002b(optJSONObject, "ticket_address"));
                groupbuy.setTicketTel(m17002b(optJSONObject, "ticket_tel"));
                groupbuy.setUrl(m17002b(optJSONObject, "url"));
                groupbuy.setProvider(m17002b(optJSONObject, "provider"));
                m17019a(groupbuy, optJSONObject);
                poiItemDetail.addGroupbuy(groupbuy);
            }
        }
    }

    /* renamed from: b */
    public static void m17006b(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Cinema cinema = new Cinema();
        cinema.setIntro(m17002b(jSONObject, "intro"));
        cinema.setRating(m17002b(jSONObject, "rating"));
        cinema.setDeepsrc(m17002b(jSONObject, "deepsrc"));
        cinema.setParking(m17002b(jSONObject, "parking"));
        cinema.setOpentimeGDF(m17002b(jSONObject, "opentime_GDF"));
        cinema.setOpentime(m17002b(jSONObject, "opentime"));
        cinema.setPhotos(m16976l(jSONObject));
        if (m16978k(jSONObject2)) {
            cinema.setSeatOrdering(m17008a(jSONObject2, "seat_ordering"));
        }
        poiItemDetail.setDeepType(PoiItemDetail.DeepType.CINEMA);
        poiItemDetail.setCinema(cinema);
    }

    /* renamed from: b */
    public static void m17004b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(m17002b(optJSONObject, "id"));
                regeocodeRoad.setName(m17002b(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(m16997c(optJSONObject, "location"));
                regeocodeRoad.setDirection(m17002b(optJSONObject, "direction"));
                regeocodeRoad.setDistance(m16981j(m17002b(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    /* renamed from: c */
    public static LatLonPoint m16997c(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            return m16989f(jSONObject.optString(str));
        }
        return null;
    }

    /* renamed from: c */
    public static DriveRouteResult m16999c(String str) {
        JSONArray optJSONArray;
        DriveRouteResult driveRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(C3670av.f14874a)) {
                driveRouteResult = new DriveRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject(C3670av.f14874a);
                if (optJSONObject != null) {
                    driveRouteResult.setStartPos(m16997c(optJSONObject, "origin"));
                    driveRouteResult.setTargetPos(m16997c(optJSONObject, "destination"));
                    driveRouteResult.setTaxiCost(m16981j(m17002b(optJSONObject, "taxi_cost")));
                    if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            DrivePath drivePath = new DrivePath();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                drivePath.setDistance(m16981j(m17002b(optJSONObject2, "distance")));
                                drivePath.setDuration(m16979k(m17002b(optJSONObject2, "duration")));
                                drivePath.setStrategy(m17002b(optJSONObject2, "strategy"));
                                drivePath.setTolls(m16981j(m17002b(optJSONObject2, "tolls")));
                                drivePath.setTollDistance(m16981j(m17002b(optJSONObject2, "toll_distance")));
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                if (optJSONArray2 != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        DriveStep driveStep = new DriveStep();
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                        if (optJSONObject3 != null) {
                                            driveStep.setInstruction(m17002b(optJSONObject3, "instruction"));
                                            driveStep.setOrientation(m17002b(optJSONObject3, "orientation"));
                                            driveStep.setRoad(m17002b(optJSONObject3, "road"));
                                            driveStep.setDistance(m16981j(m17002b(optJSONObject3, "distance")));
                                            driveStep.setTolls(m16981j(m17002b(optJSONObject3, "tolls")));
                                            driveStep.setTollDistance(m16981j(m17002b(optJSONObject3, "toll_distance")));
                                            driveStep.setTollRoad(m17002b(optJSONObject3, "toll_road"));
                                            driveStep.setDuration(m16981j(m17002b(optJSONObject3, "duration")));
                                            driveStep.setPolyline(m16993d(optJSONObject3, "polyline"));
                                            driveStep.setAction(m17002b(optJSONObject3, AuthActivity.ACTION_KEY));
                                            driveStep.setAssistantAction(m17002b(optJSONObject3, "assistant_action"));
                                            m17016a(driveStep, optJSONObject3);
                                            arrayList2.add(driveStep);
                                        }
                                    }
                                    drivePath.setSteps(arrayList2);
                                    arrayList.add(drivePath);
                                }
                            }
                        }
                        driveRouteResult.setPaths(arrayList);
                    }
                }
            }
            return driveRouteResult;
        } catch (JSONException e) {
            C1233d.m17031a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C1233d.m17031a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: c */
    public static ArrayList<PoiItem> m16998c(JSONObject jSONObject) {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16994d(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static void m17001c(PoiItemDetail poiItemDetail, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("discounts");
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Discount discount = new Discount();
                discount.setTitle(m17002b(optJSONObject, "title"));
                discount.setDetail(m17002b(optJSONObject, "detail"));
                discount.setStartTime(C1233d.m17027c(m17002b(optJSONObject, "start_time")));
                discount.setEndTime(C1233d.m17027c(m17002b(optJSONObject, "end_time")));
                discount.setSoldCount(m16983i(m17002b(optJSONObject, "sold_num")));
                discount.setUrl(m17002b(optJSONObject, "url"));
                discount.setProvider(m17002b(optJSONObject, "provider"));
                m17020a(discount, optJSONObject);
                poiItemDetail.addDiscount(discount);
            }
        }
    }

    /* renamed from: c */
    public static void m17000c(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Hotel hotel = new Hotel();
        hotel.setStar(m17002b(jSONObject, "star"));
        hotel.setIntro(m17002b(jSONObject, "intro"));
        hotel.setRating(m17002b(jSONObject, "rating"));
        hotel.setLowestPrice(m17002b(jSONObject, "lowest_price"));
        hotel.setDeepsrc(m17002b(jSONObject, "deepsrc"));
        hotel.setFaciRating(m17002b(jSONObject, "faci_rating"));
        hotel.setHealthRating(m17002b(jSONObject, "health_rating"));
        hotel.setEnvironmentRating(m17002b(jSONObject, "environment_rating"));
        hotel.setServiceRating(m17002b(jSONObject, "service_rating"));
        hotel.setTraffic(m17002b(jSONObject, "traffic"));
        hotel.setAddition(m17002b(jSONObject, "addition"));
        hotel.setPhotos(m16976l(jSONObject));
        poiItemDetail.setDeepType(PoiItemDetail.DeepType.HOTEL);
        poiItemDetail.setHotel(hotel);
    }

    /* renamed from: d */
    public static PoiItemDetail m16994d(JSONObject jSONObject) {
        PoiItemDetail poiItemDetail = new PoiItemDetail(m17002b(jSONObject, "id"), m16997c(jSONObject, "location"), m17002b(jSONObject, "name"), m17002b(jSONObject, "address"));
        poiItemDetail.setAdCode(m17002b(jSONObject, "adcode"));
        poiItemDetail.setProvinceName(m17002b(jSONObject, "pname"));
        poiItemDetail.setCityName(m17002b(jSONObject, "cityname"));
        poiItemDetail.setAdName(m17002b(jSONObject, "adname"));
        poiItemDetail.setCityCode(m17002b(jSONObject, "citycode"));
        poiItemDetail.setProvinceCode(m17002b(jSONObject, "pcode"));
        poiItemDetail.setDirection(m17002b(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String m17002b = m17002b(jSONObject, "distance");
            if (!m16985h(m17002b)) {
                try {
                    poiItemDetail.setDistance((int) Float.parseFloat(m17002b));
                } catch (NumberFormatException e) {
                    C1233d.m17031a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    C1233d.m17031a(e2, "JSONHelper", "parseBasePoi");
                }
                if (poiItemDetail.getDistance() == 0) {
                    poiItemDetail.setDistance(-1);
                }
            }
        }
        poiItemDetail.setTel(m17002b(jSONObject, "tel"));
        poiItemDetail.setTypeDes(m17002b(jSONObject, "type"));
        poiItemDetail.setEnter(m16997c(jSONObject, "entr_location"));
        poiItemDetail.setExit(m16997c(jSONObject, "exit_location"));
        poiItemDetail.setWebsite(m17002b(jSONObject, "website"));
        poiItemDetail.setPostcode(m17002b(jSONObject, "citycode"));
        poiItemDetail.setEmail(m17002b(jSONObject, "email"));
        if (m16987g(m17002b(jSONObject, "groupbuy_num"))) {
            poiItemDetail.setGroupbuyInfo(false);
        } else {
            poiItemDetail.setGroupbuyInfo(true);
        }
        if (m16987g(m17002b(jSONObject, "discount_num"))) {
            poiItemDetail.setDiscountInfo(false);
        } else {
            poiItemDetail.setDiscountInfo(true);
        }
        if (m16987g(m17002b(jSONObject, "indoor_map"))) {
            poiItemDetail.setIndoorMap(false);
        } else {
            poiItemDetail.setIndoorMap(true);
        }
        return poiItemDetail;
    }

    /* renamed from: d */
    public static WalkRouteResult m16995d(String str) {
        WalkRouteResult walkRouteResult;
        JSONException e;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(C3670av.f14874a)) {
                return null;
            }
            walkRouteResult = new WalkRouteResult();
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(C3670av.f14874a);
                walkRouteResult.setStartPos(m16997c(optJSONObject, "origin"));
                walkRouteResult.setTargetPos(m16997c(optJSONObject, "destination"));
                if (!optJSONObject.has("paths")) {
                    return walkRouteResult;
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                if (optJSONArray == null) {
                    walkRouteResult.setPaths(arrayList);
                    return walkRouteResult;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    WalkPath walkPath = new WalkPath();
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        walkPath.setDistance(m16981j(m17002b(optJSONObject2, "distance")));
                        walkPath.setDuration(m16979k(m17002b(optJSONObject2, "duration")));
                        if (optJSONObject2.has("steps")) {
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            ArrayList arrayList2 = new ArrayList();
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    WalkStep walkStep = new WalkStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject3 != null) {
                                        walkStep.setInstruction(m17002b(optJSONObject3, "instruction"));
                                        walkStep.setOrientation(m17002b(optJSONObject3, "orientation"));
                                        walkStep.setRoad(m17002b(optJSONObject3, "road"));
                                        walkStep.setDistance(m16981j(m17002b(optJSONObject3, "distance")));
                                        walkStep.setDuration(m16981j(m17002b(optJSONObject3, "duration")));
                                        walkStep.setPolyline(m16993d(optJSONObject3, "polyline"));
                                        walkStep.setAction(m17002b(optJSONObject3, AuthActivity.ACTION_KEY));
                                        walkStep.setAssistantAction(m17002b(optJSONObject3, "assistant_action"));
                                        arrayList2.add(walkStep);
                                    }
                                }
                                walkPath.setSteps(arrayList2);
                            }
                        }
                        arrayList.add(walkPath);
                    }
                }
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            } catch (JSONException e2) {
                e = e2;
                C1233d.m17031a(e, "JSONHelper", "parseWalkRoute");
                return walkRouteResult;
            }
        } catch (JSONException e3) {
            walkRouteResult = null;
            e = e3;
        }
    }

    /* renamed from: d */
    public static ArrayList<LatLonPoint> m16993d(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return m16991e(jSONObject.getString(str));
        }
        return null;
    }

    /* renamed from: d */
    public static void m16996d(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        Dining dining = new Dining();
        dining.setCuisines(m17002b(jSONObject, "cuisines"));
        dining.setTag(m17002b(jSONObject, "tag"));
        dining.setIntro(m17002b(jSONObject, "intro"));
        dining.setRating(m17002b(jSONObject, "rating"));
        dining.setCpRating(m17002b(jSONObject, "cp_rating"));
        dining.setDeepsrc(m17002b(jSONObject, "deepsrc"));
        dining.setTasteRating(m17002b(jSONObject, "taste_rating"));
        dining.setEnvironmentRating(m17002b(jSONObject, "environment_rating"));
        dining.setServiceRating(m17002b(jSONObject, "service_rating"));
        dining.setCost(m17002b(jSONObject, "cost"));
        dining.setRecommend(m17002b(jSONObject, "recommend"));
        dining.setAtmosphere(m17002b(jSONObject, "atmosphere"));
        dining.setOrderingWapUrl(m17002b(jSONObject, "ordering_wap_url"));
        dining.setOrderingWebUrl(m17002b(jSONObject, "ordering_web_url"));
        dining.setOrderinAppUrl(m17002b(jSONObject, "ordering_app_url"));
        dining.setOpentimeGDF(m17002b(jSONObject, "opentime_GDF"));
        dining.setOpentime(m17002b(jSONObject, "opentime"));
        dining.setAddition(m17002b(jSONObject, "addition"));
        dining.setPhotos(m16976l(jSONObject));
        if (m16978k(jSONObject2)) {
            dining.setMealOrdering(m17008a(jSONObject2, "meal_ordering"));
        }
        poiItemDetail.setDeepType(PoiItemDetail.DeepType.DINING);
        poiItemDetail.setDining(dining);
    }

    /* renamed from: e */
    public static ArrayList<LatLonPoint> m16991e(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(m16989f(str2));
        }
        return arrayList;
    }

    /* renamed from: e */
    public static ArrayList<BusStationItem> m16990e(JSONObject jSONObject) {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16988f(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static void m16992e(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String m17002b = m17002b(jSONObject, "type");
        if (m17002b.equalsIgnoreCase("hotel")) {
            m17000c(poiItemDetail, jSONObject, jSONObject2);
        }
        if (m17002b.equalsIgnoreCase("dining")) {
            m16996d(poiItemDetail, jSONObject, jSONObject2);
        }
        if (m17002b.equalsIgnoreCase("cinema")) {
            m17006b(poiItemDetail, jSONObject, jSONObject2);
        }
        if (!m17002b.equalsIgnoreCase("scenic")) {
            return;
        }
        m17017a(poiItemDetail, jSONObject, jSONObject2);
    }

    /* renamed from: f */
    public static BusStationItem m16988f(JSONObject jSONObject) {
        BusStationItem m16986g = m16986g(jSONObject);
        if (m16986g == null) {
            return m16986g;
        }
        m16986g.setAdCode(m17002b(jSONObject, "adcode"));
        m16986g.setCityCode(m17002b(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            m16986g.setBusLineItems(arrayList);
            return m16986g;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16984h(optJSONObject));
            }
        }
        m16986g.setBusLineItems(arrayList);
        return m16986g;
    }

    /* renamed from: f */
    public static LatLonPoint m16989f(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    /* renamed from: g */
    public static BusStationItem m16986g(JSONObject jSONObject) {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(m17002b(jSONObject, "id"));
        busStationItem.setLatLonPoint(m16997c(jSONObject, "location"));
        busStationItem.setBusStationName(m17002b(jSONObject, "name"));
        return busStationItem;
    }

    /* renamed from: g */
    public static boolean m16987g(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    /* renamed from: h */
    public static BusLineItem m16984h(JSONObject jSONObject) {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(m17002b(jSONObject, "id"));
        busLineItem.setBusLineType(m17002b(jSONObject, "type"));
        busLineItem.setBusLineName(m17002b(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(m16993d(jSONObject, "polyline"));
        busLineItem.setCityCode(m17002b(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(m17002b(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(m17002b(jSONObject, "end_stop"));
        return busLineItem;
    }

    /* renamed from: h */
    public static boolean m16985h(String str) {
        return str == null || str.equals("");
    }

    /* renamed from: i */
    public static int m16983i(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C1233d.m17031a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    /* renamed from: i */
    public static ArrayList<BusLineItem> m16982i(JSONObject jSONObject) {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16980j(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public static float m16981j(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            C1233d.m17031a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    /* renamed from: j */
    public static BusLineItem m16980j(JSONObject jSONObject) {
        BusLineItem m16984h = m16984h(jSONObject);
        if (m16984h == null) {
            return m16984h;
        }
        m16984h.setFirstBusTime(C1233d.m17026d(m17002b(jSONObject, "start_time")));
        m16984h.setLastBusTime(C1233d.m17026d(m17002b(jSONObject, "end_time")));
        m16984h.setBusCompany(m17002b(jSONObject, "company"));
        m16984h.setDistance(m16981j(m17002b(jSONObject, "distance")));
        m16984h.setBasicPrice(m16981j(m17002b(jSONObject, "basic_price")));
        m16984h.setTotalPrice(m16981j(m17002b(jSONObject, "total_price")));
        m16984h.setBounds(m16993d(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            m16984h.setBusStations(arrayList);
            return m16984h;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m16986g(optJSONObject));
            }
        }
        m16984h.setBusStations(arrayList);
        return m16984h;
    }

    /* renamed from: k */
    public static long m16979k(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            C1233d.m17031a(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    /* renamed from: k */
    public static boolean m16978k(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("biz_ext");
    }

    /* renamed from: l */
    public static List<Photo> m16976l(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("photos");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Photo photo = new Photo();
                    photo.setTitle(m17002b(optJSONObject, "title"));
                    photo.setUrl(m17002b(optJSONObject, "url"));
                    arrayList.add(photo);
                }
            } catch (Exception e) {
                C1233d.m17031a(e, "JSONHelper", "getPhotoList");
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public static boolean m16977l(String str) {
        return str != null && !str.equals("") && !str.equals("[]") && !str.equals("0") && str.equals("1");
    }

    /* renamed from: m */
    public static DistrictItem m16975m(JSONObject jSONObject) {
        String string;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(m17002b(jSONObject, "citycode"));
        districtItem.setAdcode(m17002b(jSONObject, "adcode"));
        districtItem.setName(m17002b(jSONObject, "name"));
        districtItem.setLevel(m17002b(jSONObject, "level"));
        districtItem.setCenter(m16997c(jSONObject, "center"));
        if (jSONObject.has("polyline") && (string = jSONObject.getString("polyline")) != null && string.length() > 0) {
            districtItem.setDistrictBoundary(string.split("\\|"));
        }
        m17011a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    /* renamed from: n */
    public static ArrayList<GeocodeAddress> m16974n(JSONObject jSONObject) {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GeocodeAddress geocodeAddress = new GeocodeAddress();
                geocodeAddress.setFormatAddress(m17002b(optJSONObject, "formatted_address"));
                geocodeAddress.setProvince(m17002b(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                geocodeAddress.setCity(m17002b(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                geocodeAddress.setDistrict(m17002b(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                geocodeAddress.setTownship(m17002b(optJSONObject, "township"));
                geocodeAddress.setNeighborhood(m17002b(optJSONObject.optJSONObject("neighborhood"), "name"));
                geocodeAddress.setBuilding(m17002b(optJSONObject.optJSONObject("building"), "name"));
                geocodeAddress.setAdcode(m17002b(optJSONObject, "adcode"));
                geocodeAddress.setLatLonPoint(m16997c(optJSONObject, "location"));
                geocodeAddress.setLevel(m17002b(optJSONObject, "level"));
                arrayList.add(geocodeAddress);
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    public static ArrayList<Tip> m16973o(JSONObject jSONObject) {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(m17002b(optJSONObject, "name"));
                tip.setDistrict(m17002b(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(m17002b(optJSONObject, "adcode"));
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    /* renamed from: p */
    public static List<BusinessArea> m16972p(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BusinessArea businessArea = new BusinessArea();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                businessArea.setCenterPoint(m16997c(optJSONObject, "location"));
                businessArea.setName(m17002b(optJSONObject, "name"));
                arrayList.add(businessArea);
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    public static BusStep m16971q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(m16970r(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(m16969s(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(m16968t(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 == null) {
            return busStep;
        }
        busStep.setExit(m16968t(optJSONObject4));
        return busStep;
    }

    /* renamed from: r */
    public static RouteBusWalkItem m16970r(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(m16997c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(m16997c(jSONObject, "destination"));
        routeBusWalkItem.setDistance(m16981j(m17002b(jSONObject, "distance")));
        routeBusWalkItem.setDuration(m16979k(m17002b(jSONObject, "duration")));
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m16967u(optJSONObject));
                }
            }
            routeBusWalkItem.setSteps(arrayList);
            return routeBusWalkItem;
        }
        return routeBusWalkItem;
    }

    /* renamed from: s */
    public static List<RouteBusLineItem> m16969s(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("buslines")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m16966v(optJSONObject));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: t */
    public static Doorway m16968t(JSONObject jSONObject) {
        Doorway doorway = new Doorway();
        doorway.setName(m17002b(jSONObject, "name"));
        doorway.setLatLonPoint(m16997c(jSONObject, "location"));
        return doorway;
    }

    /* renamed from: u */
    public static WalkStep m16967u(JSONObject jSONObject) {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(m17002b(jSONObject, "instruction"));
        walkStep.setOrientation(m17002b(jSONObject, "orientation"));
        walkStep.setRoad(m17002b(jSONObject, "road"));
        walkStep.setDistance(m16981j(m17002b(jSONObject, "distance")));
        walkStep.setDuration(m16981j(m17002b(jSONObject, "duration")));
        walkStep.setPolyline(m16993d(jSONObject, "polyline"));
        walkStep.setAction(m17002b(jSONObject, AuthActivity.ACTION_KEY));
        walkStep.setAssistantAction(m17002b(jSONObject, "assistant_action"));
        return walkStep;
    }

    /* renamed from: v */
    public static RouteBusLineItem m16966v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(m16964x(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(m16964x(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(m17002b(jSONObject, "name"));
        routeBusLineItem.setBusLineId(m17002b(jSONObject, "id"));
        routeBusLineItem.setBusLineType(m17002b(jSONObject, "type"));
        routeBusLineItem.setDistance(m16981j(m17002b(jSONObject, "distance")));
        routeBusLineItem.setDuration(m16981j(m17002b(jSONObject, "duration")));
        routeBusLineItem.setPolyline(m16993d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(C1233d.m17026d(m17002b(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(C1233d.m17026d(m17002b(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(m16983i(m17002b(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(m16965w(jSONObject));
        return routeBusLineItem;
    }

    /* renamed from: w */
    public static List<BusStationItem> m16965w(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("via_stops")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m16964x(optJSONObject));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: x */
    public static BusStationItem m16964x(JSONObject jSONObject) {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(m17002b(jSONObject, "name"));
        busStationItem.setBusStationId(m17002b(jSONObject, "id"));
        busStationItem.setLatLonPoint(m16997c(jSONObject, "location"));
        return busStationItem;
    }
}
