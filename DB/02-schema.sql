CREATE DATABASE IF NOT EXISTS telecom_platform
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE telecom_platform;

CREATE TABLE IF NOT EXISTS telecom_plan (
    id BIGINT NOT NULL primary key AUTO_INCREMENT comment "套餐ID",
    name VARCHAR(100) NOT NULL comment "套餐名",
    monthly_fee_fen INT NOT NULL comment "每月付款",
    data_gb INT NOT NULL comment  "流量",
    status VARCHAR(16) NOT NULL DEFAULT 'ON_SALE' comment "套餐状态",

)