package com.pigo.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pigo.shop.entity.Tag;
import com.pigo.shop.mapper.TagMapper;
import com.pigo.shop.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    TagMapper mapper;

    @Override
    public List<Tag> getTagList() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public void createTag(Tag tag) {
        System.out.println(tag);
        tag.setCreateTime(String.valueOf(System.currentTimeMillis()));
        mapper.insert(tag);
    }

    @Override
    public void deleteTag(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateTag(Tag tag) {
        mapper.updateById(tag);
    }
}
