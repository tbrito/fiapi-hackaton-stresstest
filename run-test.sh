GATLING_BIN_DIR=$HOME/deps/gatling/bin

WORKSPACE=$HOME/gatling

sh $GATLING_BIN_DIR/gatling.sh -rm local -s PontoEletronicoSimulation \
    -rd "DESCRICAO" \
    -rf $WORKSPACE/user-files/results \
    -sf $WORKSPACE/user-files/simulations \
    -rsf $WORKSPACE/user-files/resources \

sleep 3