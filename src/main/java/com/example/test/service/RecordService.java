package com.example.test.service;

import java.util.List;
import com.example.test.entity.Record;

public interface RecordService {
    public void add(Record params);

    public void update(Record params);

    public List<Record> select(Record params);

    public void delete(Record params);
}
