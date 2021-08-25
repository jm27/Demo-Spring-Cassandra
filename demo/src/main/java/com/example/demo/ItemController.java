package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository){
        this.itemRepository =itemRepository;
    }

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.itemRepository.findAll(), Item.class);
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        return this.itemRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(item -> ServerResponse.ok().body(Mono.just(item), Item.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Item.class)
                .flatMap(item -> this.itemRepository.save(item))
                .flatMap(item -> ServerResponse.created(URI.create("/items/" + item.getId())).build());
    }
}
