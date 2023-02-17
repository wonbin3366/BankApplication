package shop.mtcoding.newblog.model.history;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.newblog.dto.history.HistoryRespDto;

@Mapper
public interface HistoryRepository {

    public int insert(History history);

    public int updateById(History history);

    public int deleteById(int id);

    public List<History> findAll();

    public History findById(int id);

    public List<HistoryRespDto> findByGubun(@Param("gubun") String gubun, @Param("accountId") int accountId);
}
