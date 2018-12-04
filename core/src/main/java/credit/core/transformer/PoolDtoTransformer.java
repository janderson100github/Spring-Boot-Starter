package credit.core.transformer;

import credit.db.entity.Pool;
import credit.model.PoolDto;
import org.springframework.stereotype.Component;

@Component
public class PoolDtoTransformer {

    public PoolDtoTransformer() {
    }

    public PoolDto generate(final Pool pool) {
        if (pool == null || pool.getGid() == null) {
            return null;
        }

        PoolDto dto = new PoolDto();
        dto.setPrefix(pool.getPrefix());
        dto.setId(pool.getId());
        dto.setTotal(pool.getTotal());
        dto.setDescription(pool.getDescription());
        dto.setCreated(pool.getCreated());

        return dto;
    }

    public Pool generate(final PoolDto dto) {
        return new Pool(dto.getPrefix(), dto.getId(), dto.getTotal(), dto.getDescription());
    }
}
