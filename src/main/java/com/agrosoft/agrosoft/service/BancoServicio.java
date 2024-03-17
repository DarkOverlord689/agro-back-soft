package com.agrosoft.agrosoft.service;

import java.util.List;

import com.agrosoft.agrosoft.model.BancosDTO;

public interface BancoServicio {
    List<BancosDTO> listBancos();

    void changeStatusBancos(Long id, Long estado);
}