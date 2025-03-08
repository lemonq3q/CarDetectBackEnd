package com.example.test.mapper;

import com.example.test.entity.Record;

import java.util.List;

public interface RecordMapper {

    public List<Record> select(Record params);

    public void add(Record params);

    public void update(Record params);

    public void delete(Record params);
}
