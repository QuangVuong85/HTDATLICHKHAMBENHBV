--drop database datlichkhambenhbv;

INSERT into nhomngdung (ma_nhomnd, ten_nhomnd) VALUES('N01', 'Quản trị');
INSERT into nhomngdung (ma_nhomnd, ten_nhomnd) VALUES('N02', 'Trưởng khoa');
INSERT into nhomngdung (ma_nhomnd, ten_nhomnd) VALUES('N03', 'Bác sĩ');
INSERT into nhomngdung (ma_nhomnd, ten_nhomnd) VALUES('N04', 'Y tá');
INSERT into nhomngdung (ma_nhomnd, ten_nhomnd) VALUES('N05', 'Bệnh nhân');

insert into nguoidung (matk, ma_nhomnd, mat_khau, tentk) values('1111', 'N01', '123456', 'vuongdq1');
insert into nguoidung (matk, ma_nhomnd, mat_khau, tentk) values('1112', 'N02', '123456', 'vuongdq2');
insert into nguoidung (matk, ma_nhomnd, mat_khau, tentk) values('TK01', 'N01', 'vuong123','vuonggv');
insert into nguoidung (matk, ma_nhomnd, mat_khau, tentk) values ('TK02', 'N02','vuongs2gv','vuonggv');
insert into nguoidung (matk, ma_nhomnd, mat_khau, tentk) values ('TK03','N03','nam123','123');

insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K01',N'CƠ-XƯƠNG-KHỚP','0371263881');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K02',N'THẦN KINH','0371263821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K03',N'TIÊU HÓA','0373213821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K04',N'TIM MẠCH','0356763821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K05',N'TAI MŨI HỌNG','0343263821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K06',N'CỘT SỐNG','0315263821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K07',N'Y HỌC CỔ TRUYỀN','0372143621');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K08',N'CHÂM CỨU','0377543821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K09',N'SẢN PHỤ KHOA','0376784821');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K10',N'DA LIỄU','0374363866');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K11',N'UNG BƯỚU','0371263551');
insert into KHOA (ma_khoa, ten_khoa, sodt) values ('K12',N'NHA KHOA','0371244821');

insert into Dichvu (madv, tendv, don_gia) values ('DV01',N'Khám da liễu','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV02',N'Khám mắt','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV03',N'Khám ngoại khoa','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV04',N'Khám nhi','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV05',N'Khám nội khoa','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV06',N'Khám nội tiết','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV07',N'Khám phụ sản','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV08',N'Khám răng hàm mặt','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV09',N'Khám tai mũi họng','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV10',N'Khám Y học cổ truyền ','80000');
insert into Dichvu (madv, tendv, don_gia) values ('DV11',N'Khám yêu cầu ','100000');

insert into bacsi (mabs, tenbs, chuc_vu, hinh_anh, ma_khoa, matk) values ('BS01',N'Phó Giáo sư, Tiến sĩ Vũ Thị Thanh Thủy',N'Phó trưởng khoa Cơ xương khớp',Null,'K01','TK01');
insert into bacsi (mabs, tenbs, chuc_vu, hinh_anh, ma_khoa, matk) values ('BS02',N'Thạc sĩ - Bác sĩ Nguyễn Thị Hoa',N'Bác sĩ',Null,'K01','TK02');
insert into bacsi (mabs, tenbs, chuc_vu, hinh_anh, ma_khoa, matk) values ('BS03',N'Bác sĩ Will Gunson', N'Cử nhân Khoa học Trị liệu Thần kinh Cột sống',Null,'K01','TK03');

INSERT INTO phongkham (mabs, ma_khoa, so_phong) VALUES ('BS01', 'K01', '1015');
INSERT INTO phongkham (mabs, ma_khoa, so_phong) VALUES ('BS02', 'K01', '1016');
INSERT INTO phongkham (mabs, ma_khoa, so_phong) VALUES ('BS03', 'K01', '1017');


insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN01',N'Nguyễn Văn Nam','1','0903847504','machinery@hcm.vnn.vn','128 Trần Tuấn Khải, P. 5, Q. 5','TK03');
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN02',N'Phạm Thị Hồng Thủy','0','0903847629','tmt-art@yahoo.com','5 Lê Thị Riêng, P. Bến Thành, Q. 1','TK01');
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN03',N'Lê Văn Tuyến','1','0903847694','tanphatlinh@hcm.vnn.vn','377 Ngô Gia Tự, P. 3, Q. 10','TK02');
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN04',N'Lê Tấn Hòa','1','0903847850','dang-thanh@hcm.fpt.vn','268 Lý Thường Kiệt, P. 6, Q. Tân Bình',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN05',N'Bùi Bích Hằng','0','0903848643','sales@ad-smart.com','29 Võ Văn Tần, P. 6, Q. 3',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN06',N'Nguyễn Thị Thanh Hà','0','0903848666','phusa@fusaco.com.vn','278C Nam Kỳ Khởi Nghĩa, P. 8, Q. 3',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN07',N'Hồ Tấn Phong','1','0903849356','newlight@hcm.vnn.vn','79/5D8 Xô Viết Nghệ Tĩnh, P. 26, Q. Bình Thạnh',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN08',N'Nguyễn Quang Vinh','1','0903852263','tanvietneon@email.viettel.vn','198 Cô Giang, P. Cô Giang, Q. 1',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN09',N'Đậu Phi Minh Vương','1','0903849670','giaviet@giaviet.com.vn','371 Kiốt 8,Nguyễn Kiệm, P. 3, Q. Gò Vấp',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN10',N'Nguyễn Ngọc Hiếu','1','0903852263','hungluat1067@yahoo.com','1067C1 Thoại Ngọc Hầu, P. Hòa Thạnh, Q. Tân Phú',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN11',N'Trần Thanh Bình','1','0903854114','nhatanco@yahoo.com','176/14 Hòa Bình, P. Tân Thới Hòa, Q. Tân Phú',null);
insert into benhnhan (mabn, ho_ten, gioi_tinh, sodt, email, dia_chi, matk) values ('BN12',N'Nguyễn Minh Hoàng','1','0903856592','batitrading@yahoo.com','159/3 Hoàng Văn Thụ, P. 8, Q. Phú Nhuận',null);

insert into nguoidatlich (ma_nguoi_dat, ho_ten, sodt, email, mabn) values ('TN01',N'Nguyễn Ngọc Hiếu','0903852263','hungluat1067@yahoo.com', 'BN01');
insert into nguoidatlich (ma_nguoi_dat, ho_ten, sodt, email, mabn) values ('TN02',N'Trần Thanh Bình','0903854114','nhatanco@yahoo.com','BN02');
insert into nguoidatlich (ma_nguoi_dat, ho_ten, sodt, email, mabn) values ('TN03',N'Nguyễn Minh Hoàng','0903856592','batitrading@yahoo.com','BN03');

insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs, mabn) values ('LH001', '14/12/2019', '08:30', '0', 'BS01', 'BN01');
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH002', '14/12/2019', '09:00', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH003', '14/12/2019', '09:30', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH004', '14/12/2019', '10:00', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH005', '14/12/2019', '10:30', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH006', '14/12/2019', '11:00', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH007', '14/12/2019', '11:30', '0', 'BS01'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs, mabn) values ('LH008', '14/12/2019', '08:30', '0', 'BS02', 'BN02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH009', '14/12/2019', '09:00', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH010', '14/12/2019', '09:30', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH011', '14/12/2019', '10:00', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH012', '14/12/2019', '10:30', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH013', '14/12/2019', '11:00', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH014', '14/12/2019', '11:30', '0', 'BS02'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs, mabn) values ('LH015', '14/12/2019', '08:30', '0', 'BS03', 'BN03');
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH016', '14/12/2019', '09:00', '0', 'BS03'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH017', '14/12/2019', '09:30', '0', 'BS03'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH018', '14/12/2019', '10:00', '0', 'BS03'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH019', '14/12/2019', '10:30', '0', 'BS03'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH020', '14/12/2019', '11:00', '0', 'BS03'); 
insert into lichhen (ma_lich_hen, ngay_kham, thoi_gian, trang_thai, mabs) values ('LH021', '14/12/2019', '11:30', '0', 'BS03'); 

insert into chitietdichvu (madv, ma_lich_hen, thoi_gian_dat, ghi_chu) values ('DV01', 'LH001' , current_timestamp, null);
insert into chitietdichvu (madv, ma_lich_hen, thoi_gian_dat, ghi_chu) values ('DV02', 'LH008' , current_timestamp, null);
insert into chitietdichvu (madv, ma_lich_hen, thoi_gian_dat, ghi_chu) values ('DV03', 'LH015' , current_timestamp, null);