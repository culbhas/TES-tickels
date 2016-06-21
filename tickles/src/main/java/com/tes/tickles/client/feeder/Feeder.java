package com.tes.tickles.client.feeder;

import com.tes.tickles.client.data.Data;

import java.io.IOException;

public interface Feeder {
    boolean feed(Data data);
}
