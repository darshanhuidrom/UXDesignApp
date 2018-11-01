package com.globizs.uxdesignapp.util;

import android.os.IBinder;
import android.os.RemoteException;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class DummyObjectCreationClass {

    public static Marker getDummyMarker() {
        return dummyMarker;
    }


    static Marker dummyMarker = new Marker(new zzt() {
        @Override
        public void remove() throws RemoteException {

        }

        @Override
        public String getId() throws RemoteException {
            return null;
        }

        @Override
        public void setPosition(LatLng latLng) throws RemoteException {

        }

        @Override
        public LatLng getPosition() throws RemoteException {
            return null;
        }

        @Override
        public void setTitle(String s) throws RemoteException {

        }

        @Override
        public String getTitle() throws RemoteException {
            return null;
        }

        @Override
        public void setSnippet(String s) throws RemoteException {

        }

        @Override
        public String getSnippet() throws RemoteException {
            return null;
        }

        @Override
        public void setDraggable(boolean b) throws RemoteException {

        }

        @Override
        public boolean isDraggable() throws RemoteException {
            return false;
        }

        @Override
        public void showInfoWindow() throws RemoteException {

        }

        @Override
        public void hideInfoWindow() throws RemoteException {

        }

        @Override
        public boolean isInfoWindowShown() throws RemoteException {
            return false;
        }

        @Override
        public void setVisible(boolean b) throws RemoteException {

        }

        @Override
        public boolean isVisible() throws RemoteException {
            return false;
        }

        @Override
        public boolean zzj(zzt zzt) throws RemoteException {
            return false;
        }

        @Override
        public int zzi() throws RemoteException {
            return 0;
        }

        @Override
        public void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {

        }

        @Override
        public void setAnchor(float v, float v1) throws RemoteException {

        }

        @Override
        public void setFlat(boolean b) throws RemoteException {

        }

        @Override
        public boolean isFlat() throws RemoteException {
            return false;
        }

        @Override
        public void setRotation(float v) throws RemoteException {

        }

        @Override
        public float getRotation() throws RemoteException {
            return 0;
        }

        @Override
        public void setInfoWindowAnchor(float v, float v1) throws RemoteException {

        }

        @Override
        public void setAlpha(float v) throws RemoteException {

        }

        @Override
        public float getAlpha() throws RemoteException {
            return 0;
        }

        @Override
        public void setZIndex(float v) throws RemoteException {

        }

        @Override
        public float getZIndex() throws RemoteException {
            return 0;
        }

        @Override
        public void zze(IObjectWrapper iObjectWrapper) throws RemoteException {

        }

        @Override
        public IObjectWrapper zzj() throws RemoteException {
            return null;
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    });
}
