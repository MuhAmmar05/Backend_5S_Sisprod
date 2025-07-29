package id.ac.astra.polytechnic.backend_5s_sisprod.service;

import id.ac.astra.polytechnic.backend_5s_sisprod.repository.LogPenyimpananRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.LogPenyimpananVo;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.LogPenyimpananVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogPenyimpananService {
    @Autowired
    private LogPenyimpananRepository logPenyimpananRepository;

    public DtoResponse getBySearch(String search) {
        try {
            List<Object[]> listData = logPenyimpananRepository.searchLogByNamaBarangOrZona(search, search);

            List<LogPenyimpananVo> listVos = listData.stream().map(obj -> new LogPenyimpananVo(
                    ((Number) obj[0]).intValue(),       // id_log
                    (String) obj[1],                     // nama_barang
                    (String) obj[2],                     // nama_zona
                    (LocalDateTime) obj[3],              // waktu_log
                    (String) obj[4]                      // keterangan
            )).toList();

            return new DtoResponse(200, listVos, "OK");
        } catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }
    }
}
