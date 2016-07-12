package com.tes.tickles.client.locator;

import com.tes.tickles.client.data.Asset;

import java.net.UnknownHostException;

public interface Locator {
    Asset locate() throws Exception;
}
