package pro.developia.core.domain.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseTime {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
