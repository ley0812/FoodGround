package com.brendon.lee.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brendon.lee.dao.StoreDAO;
import com.brendon.lee.exception.FoodGroundException;
import com.brendon.lee.vo.Keyword;
import com.brendon.lee.vo.Store;
import com.brendon.lee.vo.StoreCloseUnit;
import com.brendon.lee.vo.StoreReadUnit;
import com.brendon.lee.vo.StoreUpdateUnit;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 매장 관련 서비스 처리
 */
@Service
public class StoreServiceImpl implements StoreService {
    private static final char OPEN = 'Y';
    private static final char NOT_OPEN = 'N';
    private static final String PATH = "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "img"
            + File.separator;
    private static final int IMG1 = 1;
    private static final int IMG2 = 2;
    
    @Autowired
    private StoreDAO storeDAO;

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 매장정보와 사진을 등록한다. 기존의 같은 이름의 매장에 '확인필요'문장을 붙여준다.
     */
    @Override
    public void insert(Store store) {
        String directoryPath = makeDirectory(store);
        imageCopy(store.getFile1(), directoryPath, store, IMG1);
        imageCopy(store.getFile2(), directoryPath, store, IMG2);
        storeDAO.updateStoreDupilicateName(store);
        storeDAO.insert(store);
    }
    
    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 전체 매장 리스트를 받아온다.
     */
    @Override
    public ArrayList<Store> readAll(StoreReadUnit storeReadUnit) {
        return storeDAO.readAll(storeReadUnit);
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 하나의 매장의 상세정보를 받아온다.
     */
    @Override
    public Store readOne(StoreReadUnit storeReadUnit) {
        Store store = storeDAO.readOne(storeReadUnit);
        if (store == null) {
            throw new FoodGroundException("해당하는 매장이 없습니다.");
        }
        return store;
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 매장 정보를 수정한다.
     */
    @Override
    public void update(StoreUpdateUnit storeUpdateUnit) {
        storeDAO.update(storeUpdateUnit);
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 기존 매장 open 여부를 파악하여 반대값으로 저장해준다.
     */
    @Override
    public void close(StoreCloseUnit storeCloseUnit) {
        if (storeCloseUnit.getOpen() == OPEN) {
            storeCloseUnit.setOpen(NOT_OPEN);
        } else if (storeCloseUnit.getOpen() == NOT_OPEN) {
            storeCloseUnit.setOpen(OPEN);
        }
        storeDAO.delete(storeCloseUnit);
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 키워드를 이용해 검색을 한다.
     */
    @Override
    public ArrayList<Store> search(Keyword keywordObj) {
        return storeDAO.search(keywordObj);
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 사진을 저장할 폴더를 생성한다.
     */
    public String makeDirectory(Store store) {
        Path path = Paths.get(PATH + store.hashCode());
        File directory = path.toFile();
        if (false == directory.exists()) {
            directory.mkdirs();
        }
        return path.toString();
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 받아온 파일 정보를 카피하고 파일을 저장한 주소를 store객체에 넣어준다.
     */
    private void imageCopy(MultipartFile file, String directoryPath, Store store, int index) {
        if (file.isEmpty()) {
            return;
        }
        String fileName = file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(directoryPath, fileName));
            Path path = Paths.get("img" + File.separator + store.hashCode() + File.separator + fileName);
            if (index == IMG1) {
                store.setFirstImage(path.toString());
            }
            if (index == IMG2) {
                store.setSecondImage(path.toString());
            }
        } catch (IOException e) {
            throw new FoodGroundException("이미지 카피 오류");
        }
    }
}