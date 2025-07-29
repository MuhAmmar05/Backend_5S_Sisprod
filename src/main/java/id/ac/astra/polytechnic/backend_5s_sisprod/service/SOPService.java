package id.ac.astra.polytechnic.backend_5s_sisprod.service;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.SOP;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.SOPRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.LogPenyimpananVo;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.SOPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static id.ac.astra.polytechnic.backend_5s_sisprod.constant.API_URL.DOKUMEN_SOP_URL;

@Service
public class SOPService {
    @Autowired
    private SOPRepository sopRepository;

    public DtoResponse getAllSOP(String search){
        try{
            List<Object[]> listData = sopRepository.searchSOPByNamaDepartemenOrJudul(search, search);

            List<SOPVo> listVos = listData.stream().map(obj -> new SOPVo(
                    ((Number) obj[0]).intValue(),
                    (String) obj[1],
                    (String) obj[2],
                    DOKUMEN_SOP_URL + ((String) obj[3]),
                    ((Enum<?>) obj[4]).name()
            )).toList();

            return new DtoResponse(200, listVos, "OK");
        } catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }
    }
}
